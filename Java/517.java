class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length, ans = 0, sum = Arrays.stream(machines).sum(), t = sum/n, out = 0;
        if (sum%n > 0){
            return -1;
        }
        for (int m : machines){
            out += m - t;
            ans = Math.max(ans, Math.max(Math.abs(out), m - t));
        }
        return ans;
    }
}
