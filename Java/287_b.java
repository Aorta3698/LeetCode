class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            ans.add(new ArrayList<>());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] m : matches){
            map.merge(m[1], 1, Integer::sum);
            map.merge(m[0], 0, Integer::sum);
        }
        for (int key : map.keySet()){
            int val = map.get(key);
            if (val > 1){
                continue;
            }
            ans.get(val).add(key);
        }
        for (int i = 0; i < 2; i++){
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}
