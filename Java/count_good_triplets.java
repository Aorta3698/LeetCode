class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                for (int o = j + 1; o < len; o++)
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[o]) <= b
                            && Math.abs(arr[i] - arr[o]) <= c)
                        count++;

        return count;
    }
}
