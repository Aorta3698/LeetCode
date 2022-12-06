https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/discuss/2373099/Weak-Test-Cases-or-Incorrect-Code-got-AC
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length, ans = 0;
        for (int i = 1; i < 1<<m; i++){
            int[] cnt = new int[n];
            for (int j = 0; j < m; j++){
                if ((i&1<<j)>0){
                    cnt[requests[j][0]]++;
                    cnt[requests[j][1]]--;
                }
            }
            boolean ok = true;
            for (int c : cnt){
                ok &= c == 0;
            }
            if (ok){
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }
}
