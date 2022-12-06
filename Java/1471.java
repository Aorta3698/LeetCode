class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int lo = 0, hi = arr.length - 1, j = 0, m = arr[(arr.length - 1) / 2];
        while(--k >= 0){
            if (m - arr[lo] > arr[hi] - m){
                ans[j++] = arr[lo++];
            }else{
                ans[j++] = arr[hi--];
            }
        }

        return ans;
    }
}
