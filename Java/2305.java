class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return backtrack(0, cookies, new int[k]);
    }

    private int backtrack(int j, int[] cookies, int[] groups){
        if (j == cookies.length)
            return Arrays.stream(groups).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < groups.length; i++){
            groups[i] += cookies[j];
            ans = Math.min(backtrack(j+1, cookies, groups), ans);
            groups[i] -= cookies[j];
        }
        return ans;
    }
}

// class Solution {
//     public int distributeCookies(int[] cookies, int k) {
//         return backtrack(k, 0, 0, 0, 0, cookies);
//     }

//     private int backtrack(int k, int j, int sum, int seen, int max, int[] cookies){
//         if (j == cookies.length){
//             if (--k == 0 && seen == (1 << cookies.length)-1){
//                 return Math.max(max, sum);
//             }else if (seen == (1 << cookies.length)-1||k==0){
//                 return Integer.MAX_VALUE;
//             }else{
//                 return backtrack(k, 0, 0, seen, Math.max(max, sum), cookies);
//             }
//         }
//         return Math.min(backtrack(k, j+1, sum, seen, max, cookies),
//                 (seen & (1<<j)) > 0? Integer.MAX_VALUE : backtrack(k, j+1, sum+cookies[j], seen|(1<<j), max, cookies));
//     }
// }
