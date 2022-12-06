https://leetcode.com/problems/brightest-position-on-street/discuss/1655440/Java-or-TreeMap-or-Shot-and-Concise-or-Thinking-Process
class Solution {
    public int brightestPosition(int[][] lights) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int[] g : lights){
            map.merge(g[0] - g[1], 1, Integer::sum);
            map.merge(g[0] + g[1] + 1, -1, Integer::sum);
        }

        int ans = 0, sum = 0, max = 0;
        for (int key : map.keySet()){
            sum += map.get(key);
            if (sum > max){
                max = sum;
                ans = key;
            }
        }

        return ans;
    }
}
