class Solution {
    public int longestSubsequence(int[] arr, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : arr){
            map.put(n, 1 + map.getOrDefault(n - d, 0));
            ans = Math.max(map.get(n), ans);
        }

        return ans;
    }
}
