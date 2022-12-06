class Solution {
    int[] map = IntStream.range(0, 10).toArray();
    int[] g = new int[]{0, 1, 6, 9 ,8};
    int[] m = new int[]{0, 1, 8};
    long[] exp = new long[10];
    public int strobogrammaticInRange(String low, String high) {
        map[6]=9;
        map[9]=6;
        map[2]=map[3]=map[5]=map[7]=map[4]=-1;
        exp[0]=1;
        for (int i = 1; i < 10; i++){
            exp[i]=10*exp[i-1];
        }
        return solve(high) - solve(low) + (Long.valueOf(high) == rotate(Long.valueOf(high))? 1 : 0);
    }

    private int solve(String s){
        int ans = 0;
        long max = Long.valueOf(s);
        for (int sz = 1; sz <= s.length(); sz++){
            ans += go(0, 0L, sz, max);
        }
        return ans;
    }

    private int go(int len, long cur, int sz, long max){
        if (len == sz/2){
            long L = cur*exp[len+(sz&1)], R = rotate(cur);
            int ans = 0;
            if (sz % 2 == 0){
                ans += (L+R<max? 1 : 0);
            }else{
                for (int i = 0; i < 3; i++){
                    ans += (L + m[i]*exp[len] + R < max? 1 : 0);
                }
            }
            return ans;
        }
        int ans = 0;
        for (int n : g){
            if (cur == 0 && n > 0 || cur > 0){
                ans += go(len+1, 10*cur+n, sz, max);
            }
        }
        return ans;
    }

    private long rotate(long n){
        long N = n, cur = 0;
        while(n > 0 && map[(int)(n%10)]!=-1){
            cur *= 10;
            cur += map[(int)(n%10)];
            n/=10;
        }
        return n > 0? -1 : cur;
    }
}
