class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++){
            for (int n : nums.get(i)){
                map.computeIfAbsent(n, o -> new HashSet<>()).add(i);
            }
        }
        List<Integer> data = new ArrayList<>(map.keySet());
        Collections.sort(data);

        int uniq = 0;
        int[] ans = new int[]{0, Integer.MAX_VALUE};
        int[] count = new int[nums.size()];
        for (int i = 0, j = 0; i < data.size(); i++){
            for (int k : map.get(data.get(i))){
                if (++count[k] == 1){
                    ++uniq;
                }
            }
            while(uniq == nums.size()){
                if (data.get(i) - data.get(j) < ans[1] - ans[0]){
                    ans[0] = data.get(j);
                    ans[1] = data.get(i);
                }
                for (int k : map.get(data.get(j++))){
                    if (--count[k] == 0){
                        --uniq;
                    }
                }
            }
        }

        return ans;
    }
}
