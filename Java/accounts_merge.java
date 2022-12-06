https://leetcode.com/problems/accounts-merge/discuss/1601792/Java-UnionFind-With-detailed-explanations-and-thought-process.

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Collections.sort(accounts, Comparator.comparing(o -> o.get(0)));
        List<List<String>> ans = new ArrayList<>();

        int idx = 0;
        while(idx < accounts.size()){
            List<List<String>> groupByName = new ArrayList<>();
            String name = accounts.get(idx).get(0);
            while(idx < accounts.size() && name.equals(accounts.get(idx).get(0)))
                groupByName.add(accounts.get(idx++));

            UnionFind uf = new UnionFind(9 * groupByName.size());
            int id = 0;
            HashMap<String, Integer> map = new HashMap<>();

            for (List<String> entry : groupByName){
                for (int i = 1; i < entry.size(); i++){
                    String cur = entry.get(i);
                    String next = entry.get(Math.min(i + 1, entry.size() - 1));
                    if (!map.containsKey(cur)) map.put(cur, id++);
                    if (!map.containsKey(next))map.put(next, id++);

                    uf.union(map.get(cur), map.get(next));
                }
            }

            HashMap<Integer, HashSet<String>> samePerson = new HashMap<>();
            for (List<String> e : groupByName) {
                int key = uf.find(map.get(e.get(1)));
                samePerson.putIfAbsent(key, new HashSet<>());
                for (int i = 1; i < e.size(); i++) samePerson.get(key).add(e.get(i));
            }

            for (List<String> e : groupByName){
                int key = uf.find(map.get(e.get(1)));
                if (!samePerson.containsKey(key)) continue;
                List<String> person = new ArrayList<>();
                List<String> emails = new ArrayList<>(samePerson.get(key));
                person.add(name);
                Collections.sort(emails);
                person.addAll(emails);
                ans.add(person);
                samePerson.remove(key);
            }
        }

        return ans;
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int r){
            if (nums[r] != r) nums[r] = find(nums[r]);
            return nums[r];
        }

        private void union(int i, int j){
            i = find(i);
            j = find(j);
            if (ranks[i] > ranks[j])
                nums[j] = i;
            else if (ranks[i] < ranks[j])
                nums[i] = j;
            else{
                nums[j] = i;
                ranks[i]++;
            }
        }
    }
}
