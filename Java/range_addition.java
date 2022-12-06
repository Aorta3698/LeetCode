https://leetcode.com/problems/range-addition/discuss/1626551/Java-or-9-Lines-or-PreProcessing-or-Explained
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        HashMap<Integer, Integer> startMap = new HashMap<>();
        HashMap<Integer, Integer> endMap   = new HashMap<>();
        for (int[] u : updates){
            startMap.merge(u[0], u[2], Integer::sum);
            endMap.merge(u[1] + 1, u[2], Integer::sum);
        }

        for (int i = 0; i < length; i++)
            ans[i] = ans[Math.max(0, i - 1)] + startMap.getOrDefault(i, 0) - endMap.getOrDefault(i, 0);

        return ans;
    }
}
