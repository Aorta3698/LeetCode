https://leetcode.com/problems/maximum-good-people-based-on-statements/discuss/2399298/Java-or-O(N-*-2N)-or-Better-than-N2-*-2N
class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length, ans = 0;
        int[][] state = new int[n][3];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                state[i][statements[i][j]]|=1<<j;
            }
        }
        for (int i = 1 ; i < 1<<n; i++){
            int good = i, bad = (1<<n)-1-i;
            for (int j = 0; j < n; j++){
                if ((i&1<<j)>0){
                    bad |=state[j][0];
                    good|=state[j][1];
                }
            }
            if ((bad & good)==0){
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }
}

// [2,0,2,2,0] -> bad: 10010, good:     0
// [2,2,2,1,2] -> bad:     0, good: 01000
// [2,2,2,1,2] -> bad:     0, good: 01000
// [1,2,0,2,2] -> bad: 00100, good:     1
// [1,0,2,1,2] -> bad: 00010, good: 10010
