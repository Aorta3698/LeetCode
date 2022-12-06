class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        int M = (int)1e9+7;
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] cnt = new int[31];
        long[] dp = new long[1<<primes.length];
        dp[0]=1;
        for (int n : nums){
            cnt[n]++;
        }
        for (int i = 2; i <= 30; i++){
            if (cnt[i]==0){
                continue;
            }
            boolean ok = true;
            int mask = 0;
            for (int j = 0; j < primes.length && ok; j++){
                int p = primes[j];
                ok &= i % (p*p) > 0;
                if (i%p==0){
                    mask|=1<<j;
                }
            }
            int oppo = ((1<<primes.length)-1)^mask;
            for (int s = oppo; ok; s = (s-1)&oppo){
                dp[mask|s]+=cnt[i]*dp[s];
                dp[mask|s]%=M;
                if (s==0){
                    break;
                }
            }
        }
        long ans = (Arrays.stream(dp).sum()-1)%M, res = 2;
        while(cnt[1]>0){
            if ((cnt[1]&1)>0){
                ans *= res;
                ans %= M;
            }
            cnt[1]>>=1;
            res*=res;
            res%=M;
        }
        return (int)ans;
    }
}
