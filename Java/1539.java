class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] count = new int[1001];
        for (int n : arr) count[n]++;
        for (int i = 1; i < 1001; ++i)
            if (count[i] == 0 && --k == 0)
                return i;

        return k + 1000;
    }
}
