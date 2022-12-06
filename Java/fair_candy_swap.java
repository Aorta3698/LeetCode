class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //alice sum - a + b == bob sum - b + a
        //alice sum - bob sum == 2a - 2b
        int diff = Arrays.stream(aliceSizes).sum() - Arrays.stream(bobSizes).sum();
        diff /= 2;
        Set<Integer> set = new HashSet<>();
        for (int n : aliceSizes) set.add(n);
        for (int n : bobSizes)
            if (set.contains(n + diff))
                return new int[]{n + diff, n};
        return null;
    }
}
