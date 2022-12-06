class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, skip = n / 20;
        double sum = 0;
        for (int i = skip; i < n - skip; i++)
            sum += arr[i];

        return sum /(n - 2 * skip);
    }
}
