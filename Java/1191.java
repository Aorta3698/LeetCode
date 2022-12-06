class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int kadane = 0, cur = 0, n = arr.length, m = (int)(1e9 + 7), sum = Arrays.stream(arr).sum();
        for (int i = 0; i < Math.min(2, k) * n; i++){
            int j = i % n;
            cur = Math.max(cur + arr[j], arr[j]);
            kadane = Math.max(kadane, cur);
        }

        return k <= 2 || kadane > kadane + 1L * (k - 2) * sum?
            kadane % m : (int)((kadane + 1L * (k - 2) * sum) % m);
    }
}

// class Solution {
//     public int kConcatenationMaxSum(int[] arr, int k) {
//         int kadane = 0, cur = 0, n = arr.length, m = (int)(1e9 + 7);
//         for (int i = 0; i < Math.min(2, k) * n; i++){
//             int j = i % n;
//             cur = Math.max(cur + arr[j], arr[j]);
//             kadane = Math.max(kadane, cur);
//         }
//         if (k <= 2)
//             return kadane % m;

//         int min = 0, max = 0, sum = 0;
//         for (int i = 0 ; i < n; i++){
//             sum += arr[i];
//             min = Math.min(sum, min);
//             max = Math.max(sum, max);
//         }

//         long other = (sum - min) + 1L * sum * (k - 2) + max;
//         return other > kadane? (int)(other % m) : kadane % m;
//     }
// }
