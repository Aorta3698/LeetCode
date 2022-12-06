class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int curEnd = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] pair : pairs){
            if (pair[0] > curEnd){
                ans++;
                curEnd = pair[1];
            }
        }

        return ans;
    }
}
