class Solution {
    private static final long M = (int)1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++){
            long min = arr[i];
            for (int j = i; j < arr.length; j++){
                min = Math.min(arr[j], min);
                ans += min;
            }
        }

        return (int)(ans % M);
    }
}
