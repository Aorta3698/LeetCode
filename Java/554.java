class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (List<Integer> w : wall){
            for (int i = 0, sum = 0; i < w.size()-1; i++){
                sum += w.get(i);
                ans = Math.max(ans, map.merge(sum, 1, Integer::sum));
            }
        }
        return wall.size() - ans;
    }
}
