class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length(), n = strs.length, ans = 0;
        boolean[] ok = new boolean[n];
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                if (!ok[j - 1] && strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    ++ans;
                    break;
                }
                for (int k = 1; k < n && j == n - 1; k++){
                    ok[k - 1] |= strs[k - 1].charAt(i) < strs[k].charAt(i);
                }
            }
        }
        return ans;
    }
}

// import java.math.BigInteger;
// class Solution {
//     public int minDeletionSize(String[] strs) {
//         int ans = 0, n = strs.length;
//         BigInteger m = BigInteger.valueOf(26).pow(strs[0].length() - 1);
//         BigInteger[] weight = new BigInteger[n];
//         Arrays.setAll(weight, o -> BigInteger.ZERO);

//         for (int i = 0; i < strs[0].length(); i++){
//             BigInteger[] copy = weight.clone();
//             for (int j = 0; j < n; j++){
//                 copy[j] = copy[j].add(BigInteger.valueOf(strs[j].charAt(i) - 'a').multiply(m));
//                 if (j > 0 && copy[j].compareTo(copy[j - 1]) < 0){
//                     ans++;
//                     break;
//                 }
//                 if (j == n - 1){
//                     weight = copy;
//                 }
//             }
//             m = m.divide(BigInteger.valueOf(26));
//         }

//         return ans;
//     }
// }
