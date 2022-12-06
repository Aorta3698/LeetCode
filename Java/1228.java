class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length, d = (arr[n - 1] - arr[0]) / n;
        for (int i = 1; i < n; i++)
            if (arr[i] - d != arr[i - 1])
                return arr[i] - d;
        return -1;
    }
}
