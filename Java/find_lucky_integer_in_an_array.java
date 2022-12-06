class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int n : arr) count[n]++;
        for (int i = 500; i > 0; i--)
            if (i == count[i])
                return i;
        return -1;
    }
}
