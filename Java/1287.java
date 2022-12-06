class Solution {
    public int findSpecialInteger(int[] arr) {
        int prev = arr[0], count = 0;
        for (int n : arr){
            if (n == prev) count++;
            else count = 0;
            if (count > arr.length / 4) return n;
            prev = n;
        }

        return -1;
    }
}
