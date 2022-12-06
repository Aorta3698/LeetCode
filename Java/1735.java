class Solution {
    int M = (int)1e9+7;
    public int[] waysToFillArray(int[][] queries) {
        int[] ans = new int[queries.length];
        long[] inv = new long[20001];
        long[] fact = new long[20001];
        long[] facti = new long[20001];
        fact[0]=fact[1]=facti[0]=facti[1]=inv[1]=1;
        for (int i = 2; i < 20001; i++){
            inv[i]=M-M/i*inv[M%i]%M;
            fact[i]=fact[i-1]*i%M;
            facti[i]=facti[i-1]*inv[i]%M;
        }
        for (int i = 0; i < queries.length; i++){
            int n = queries[i][0];
            int k = queries[i][1];
            int tmp = k;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 2; j*j<=tmp; j++){
                while(tmp%j==0){
                    tmp/=j;
                    map.merge(j, 1, Integer::sum);
                }
            }
            if (tmp>1){
                map.merge(tmp, 1, Integer::sum);
            }
            long gain = 1;
            for (int val : map.values()){
                gain *= comb(n+val-1, val, fact, facti);
                gain %= M;
            }
            ans[i]=(int)gain;
        }
        return ans;
    }

    private long comb(int a, int b, long[] fact, long[] facti){
        return fact[a]*facti[b]%M*facti[a-b]%M;
    }
}
