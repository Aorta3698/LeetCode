https://leetcode.com/problems/number-of-single-divisor-triplets/discuss/1844073/Java-Simple-Solution-or-Explained
class Solution {
    public long singleDivisorTriplet(int[] nums) {
        long ans = 0;
        int[] count = new int[101];
        for (int n : nums){
            count[n]++;
        }
        for (int i = 1; i <= 100; i++){
            for (int j = i; j <= 100 && count[i] > 0; j++){
                for (int k = j; k <= 100 && count[j] > 0; k++){
                    int sum = i + j + k;
                    int n = 0;
                    long add = 1L * count[i] * count[j] * count[k];
                    if (sum % i == 0) n++;
                    if (sum % j == 0) n++;
                    if (sum % k == 0) n++;
                    if (n != 1 || add == 0) continue;
                    if (i == j || j == k) add = (add * (count[j] - 1)) / (2 * count[j]);
                    ans += 6L * add;
                }
            }
        }

        return ans;
    }
}

// class Solution {
//     public long singleDivisorTriplet(int[] nums) {
//         long ans = 0;
//         int[] count = new int[101];
//         for (int n : nums){
//             count[n]++;
//         }
//         for (int i = 1; i <= 100; i++){
//             if (count[i] == 0) continue;
//             for (int j = i; j <= 100; j++){
//                 if (count[j] == 0) continue;
//                 for (int k = j; k <= 100; k++){
//                     int sum = i + j + k;
//                     int n = 0;
//                     if (sum % i == 0) n++;
//                     if (sum % j == 0) n++;
//                     if (sum % k == 0) n++;
//                     if (n != 1 || count[k] == 0) continue;
//                     long add = 1L * count[i] * count[j] * count[k];
//                     if (i == j || j == k) add = (add * (count[j] - 1)) / (2 * count[j]);
//                     ans += 6L * add;
//                 }
//             }
//         }

//         return ans;
//     }
// }
