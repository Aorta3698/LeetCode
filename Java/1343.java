class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, n = arr.length, t = k * threshold;
        for (int i = 0; i < k; i++) sum += arr[i];
        int ans = sum < t? 0 : 1;
        for (int i = k; i < n; i++){
            sum += arr[i];
            sum -= arr[i - k];
            ans = sum < t? ans : ++ans;
        }

        return ans;
    }
}
