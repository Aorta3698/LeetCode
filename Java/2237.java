https://leetcode.com/problems/count-positions-on-street-with-required-brightness/discuss/1945786/Line-Sweep-or-Similar-to-2021.-Brightest-Position-on-Street-Java
class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] light = new int[n+1];
        for (int[] g : lights){
            light[Math.max(0, g[0] - g[1])]++;
            light[Math.min(n - 1, g[0] + g[1]) + 1]--;
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            if (i > 0){
                light[i] += light[i - 1];
            }
            if (light[i] >= requirement[i]){
                ans++;
            }
        }

        return ans;
    }
}
