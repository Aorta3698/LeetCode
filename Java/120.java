class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (List<Integer> t : triangle){
            for (int i = t.size()-1; i >= 0; i--){
                if (i == 0){
                    dp[i]+=t.get(i);
                }else if (i==t.size()-1){
                    dp[i]=dp[i-1]+t.get(i);
                }else{
                    dp[i]=Math.min(dp[i],dp[i-1])+t.get(i);
                }
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
