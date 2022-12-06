class Solution {
    public String lastSubstring(String s) {
        s += "$";
        int n = s.length(), top = 1;
        char[] A = s.toCharArray();
        int[] labels = new int[n];
        int[] idx= new int[n];
        int[] cnt = new int[Math.max(n, 256)];
        for (char ch : A){
            cnt[ch]++;
        }
        for (int i = 1; i < 256; i++){
            cnt[i] += cnt[i-1];
        }
        for (int i = 0; i < n; i++){
            idx[--cnt[A[i]]]=i;
        }
        for (int i = 1; i < n; i++){
            labels[idx[i]]=A[idx[i]]!=A[idx[i-1]]? top++ : top-1;
        }
        for(int k = 1; k < n; k <<= 1){
            int[] ni = new int[n];
            for (int i = 0; i < n; i++){
                ni[i]=(idx[i]-k+n)%n;
            }
            Arrays.fill(cnt, 0, top, 0);
            for (int i = 0; i < n; i++){
                cnt[labels[ni[i]]]++;
            }
            for (int i = 1; i < top; i++){
                cnt[i] += cnt[i-1];
            }
            for (int i = n-1; i >= 0; i--){
                idx[--cnt[labels[ni[i]]]]=ni[i];
            }
            int t=1;
            int[] nl = new int[n];
            for (int i = 1; i < n; i++){
                // nl[idx[i]]=labels[idx[i]]==labels[idx[i-1]]&&labels[(idx[i]+k)%n]==labels[(idx[i-1]+k)%n]? t-1 : t++;
                nl[idx[i]]=labels[idx[i]]==labels[idx[i-1]]&&labels[idx[i]+k]==labels[idx[i-1]+k]? t-1 : t++;
            }
            labels = nl;
            top = t;
        }

        return s.substring(idx[n-1], n-1);
    }
}


// class Solution {
//     public String lastSubstring(String s) {
//         int n = s.length();
//         int[][] dp = new int[n+1][n+1];
//         for (int i = n-1; i >= 0; i--){
//             for (int j = n-1; j >= 0; --j){
//                 if (s.charAt(i) == s.charAt(j)){
//                     dp[i][j] = dp[i+1][j+1]+1;
//                 }
//             }
//         }
//         int max = n-1;
//         for (int i = n-2; i >= 0; i--){
//             if (max+dp[i][max] == n || s.charAt(max+dp[i][max]) < s.charAt(i+dp[i][max])){
//                 max=i;
//             }
//         }
//         return s.substring(max);
//     }
// }
