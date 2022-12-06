class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) arr[i] ^= arr[i - 1];
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] q : queries)
            ans[idx++] = arr[q[1]] ^ (q[0] == 0? 0 : arr[q[0] - 1]);

        return ans;
    }
}
