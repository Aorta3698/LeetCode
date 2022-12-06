https://leetcode.com/problems/minimum-incompatibility/discuss/2292073/Java-or-Iterative-DP

class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        k=nums.length/k;
        int n = nums.length,INF=100;
        int[][] dp = new int[1<<n][n];
        for (int[] d : dp){
            Arrays.fill(d, INF);
        }
        for (int i=0;i<n;i++){
            dp[1<<i][i]=0;
        }
        for (int i = 1; i < 1<<n; i++){
            int c = Integer.bitCount(i);
            for (int j=0;j<n&&c%k==0;j++){
                for (int w=0;w<n&&(i&1<<j)>0;w++){
                    if ((i&1<<w)==0){
                        dp[i|1<<w][w]=Math.min(dp[i|1<<w][w], dp[i][j]);
                    }
                }
            }
            for (int j=0;j<n&&c%k!=0;j++){
                for (int w=j+1;w<n&&(i&1<<j)>0;w++){
                    if ((i&1<<w)==0&&nums[w]!=nums[j]){
                        dp[i|1<<w][w]=Math.min(dp[i|1<<w][w], dp[i][j]+nums[w]-nums[j]);
                    }
                }
            }
        }
        int ans = Arrays.stream(dp[(1<<n)-1]).min().getAsInt();
        return ans==INF?-1:ans;
    }
}



class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length/k,cnt=0,INF=100;
        BitSet[] bits = new BitSet[nums.length];
        Arrays.setAll(bits, o -> new BitSet());
        int[] dp = new int[1<<nums.length];
        int[] map = new int[1<<nums.length];
        Arrays.fill(dp, INF);
        int[] seen = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            seen[nums[i]]=i;
        }
        for (int v = (1<<n)-1; v<1<<nums.length; v=next(v)){
            int max = 0, min = INF;
            // boolean[] seen = new boolean[nums.length+1];
            boolean ok = true;
            for (int j = 0; j < nums.length&&ok; j++){
                if ((v&1<<j)>0){
                    ok &= !(seen[nums[j]]!=j&&(v&1<<seen[nums[j]])>0);
                    seen[nums[j]]=j;
                    // ok &= !seen[nums[j]];
                    // seen[nums[j]]=true;
                    min=Math.min(min, nums[j]);
                    max=Math.max(max, nums[j]);
                }
            }
            for (int j = 0; j < nums.length && ok; j++){
                if ((v&1<<j)==0){
                    bits[j].set(cnt);
                }
            }
            if (ok){
                dp[v]=max-min;
                map[cnt++]=v;
            }
        }
        for (int i = 1; i < k; i++){
            for (int v = (1<<i*n)-1; v<1<<nums.length; v=next(v)){
                BitSet cur = new BitSet();
                cur.set(0, cnt);
                for (int j = 0; j < nums.length; j++){
                    if ((v&1<<j)>0){
                        cur.and(bits[j]);
                    }
                }
                for (int j = cur.nextSetBit(0); j>=0; j=cur.nextSetBit(j+1)){
                    dp[map[j]|v]=Math.min(dp[map[j]|v],dp[map[j]]+dp[v]);
                }
            }
        }
        return dp[(1<<nums.length)-1]==INF?-1:dp[(1<<nums.length)-1];
    }

    private int next(int v){
        int t = (v | (v - 1)) + 1;
        v = t | ((((t & -t) / (v & -v)) >> 1) - 1);
        return v;
    }
}
