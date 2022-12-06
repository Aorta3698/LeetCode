class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++){
            int key = groupSizes[i];
            map.putIfAbsent(key, new ArrayList<>());
            List<Integer> l = map.get(key);
            l.add(i);
            if (l.size() == key){
                ans.add(l);
                map.put(key, new ArrayList<>());
            }
        }

        return ans;
    }
}
