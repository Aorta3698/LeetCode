class Solution {
    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE, sum = 0, del = 0, max = ans;
        for (int n : arr){
            del = Math.max(del + n, sum);
            sum = Math.max(sum + n, n);
            ans = Math.max(ans, Math.max(sum, del));
            max = Math.max(n, max);
        }

        return ans == 0? max : ans;
    }
}
