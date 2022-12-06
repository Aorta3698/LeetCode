class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0, n = arr.length;
        int[] right = new int[n];
        int[] left = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++){
            int j = n - 1 - i;
            left[i] = arr[i] > arr[i - 1]? left[i - 1] + 1 : 1;
            right[j] = arr[j] > arr[j + 1]? right[j + 1] + 1 : 1;
        }

        for (int i = 1; i < n - 1; i++){
            if (left[i] > left[i + 1] && right[i] > right[i - 1]){
                ans = Math.max(left[i] + right[i] - 1, ans);
            }
        }

        return ans;
    }
}
