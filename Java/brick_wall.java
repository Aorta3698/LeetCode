https://leetcode.com/problems/brick-wall/discuss/1634940/Java-6-Lines-HashMap-Prefix-Sum-Comments
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall){
            for (int i = 0; i < w.size() - 1; i++){
                if(i > 0) w.set(i, w.get(i - 1) + w.get(i));
                max = Math.max(map.merge(w.get(i), 1, Integer::sum), max);
            }
        }

        return wall.size() - max;
    }
}
