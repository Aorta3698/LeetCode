class Solution {
    int[] map = IntStream.range(0, 10).toArray();
    int[] g = new int[]{0, 1, 6, 8, 9};
    public int confusingNumberII(int n) {
        map[6]=9;
        map[9]=6;
        return solve(0, n);
    }

    private int solve(int cur, int n){
        if (cur > n){
            return 0;
        }
        int ans = check(cur);
        for (int ch : g){
            if (ch == 0 && cur == 0 || (Integer.MAX_VALUE-ch)/10 < cur){
                continue;
            }
            ans += solve(cur*10+ch, n);
        }
        return ans;
    }

    private int check(int n){
        long cur = 0, N = n;
        while(n > 0){
            cur *= 10;
            cur += map[n%10];
            n/=10;
        }
        return cur != N && n == 0? 1 : 0;
    }
}
