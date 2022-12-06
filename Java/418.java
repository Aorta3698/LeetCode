https://leetcode.com/problems/sentence-screen-fitting/discuss/1924564/Java-or-0ms-or-Optimal-Solution-O(length-of-words)-or-Explained.
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sum = 0, unit = 0, n = sentence.length;
        int[] lookup = new int[11 * n];
        int[] pre = new int[n];
        int[] dp = new int[n];
        int[] seen = new int[n];
        for (int i = 0; i < n; i++){
            pre[i] = sum;
            sum += sentence[i].length() + 1;
            for (int j = sum - 1; i < n - 1 && j < sum + sentence[i + 1].length(); j++){
                lookup[j] = i + 1;
            }
        }

        for (int i = 0, cur = 0, k = cols; i < rows; k = cols, i++){
            seen[cur] = i + 1;
            int need = sum - pre[cur] - 1;
            if (k >= need){
                k -= need;
                unit += k / sum + 1;
                cur = lookup[(--k + sum) % sum];
                // cur = k == 0? 0 : lookup[--k % sum];
            }else{
                cur = lookup[pre[cur] + k];
            }
            if (seen[cur] > 0){
                int cycle = i + 1 - seen[cur] + 1;
                int count = (rows - i - 1) / cycle;
                i += count * cycle;
                unit += count * (unit - dp[cur]);
            }else{
                dp[cur] = unit;
            }
        }

        return unit;
    }
}

// class Solution {
//     public int wordsTyping(String[] sentence, int rows, int cols) {
//         int sum = 0, n = sentence.length;
//         int[] lookup = new int[1001];
//         int[] pre = new int[n];
//         int[] gain = new int[n];
//         int[] count = new int[n];
//         for (int i = 0; i < n; i++){
//             pre[i] = sum;
//             sum += sentence[i].length() + 1;
//             int lim = i < n - 1? sum + sentence[i + 1].length() : 1000;
//             for (int j = sum - 1; j < lim; j++){
//                 lookup[j] = i + 1;
//             }
//         }

//         for (int i = 0, cur = 0, k = cols; i < rows; k = cols, i++){
//             count[cur]++;
//             int need = sum - pre[cur] - 1;
//             if (k >= need){
//                 k -= need;
//                 gain[cur] = k / sum + 1;
//                 cur = lookup[Math.max(k % sum - 1, 0)];
//             }else{
//                 cur = lookup[pre[cur] + k];
//             }
//         }

//         int ans = 0;
//         for (int i = 0; i < n; i++){
//             ans += gain[i] * count[i];
//         }

//         return ans;
//     }
// }
