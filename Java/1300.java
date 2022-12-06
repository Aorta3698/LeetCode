class Solution {
    public int findBestValue(int[] arr, int target) {
        if (diff(arr, Integer.MAX_VALUE, target) <= 0){
            return Arrays.stream(arr).max().getAsInt();
        }

        int lo = 0, hi = target;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            if (diff(arr, mid, target) < 0) lo = mid;
            else hi = mid - 1;
        }

        return Math.abs(diff(arr, lo, target)) <= Math.abs(diff(arr, lo + 1, target))?
            lo : lo + 1;
    }

    private int diff(int[] arr, int val, int target){
        int sum = 0;
        for (int n : arr){
            sum += Math.min(n, val);
        }

        return sum - target;
    }
}
