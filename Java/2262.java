class Solution {
    public long appealSum(String s) {
        long ans = 0, cur = 0;
        int[] prev = new int[26];
        for (int i = 0; i < s.length(); i++){
            cur += i + 1 - prev[s.charAt(i) - 'a'];
            prev[s.charAt(i) - 'a'] = i + 1;
            ans += cur;
        }

        return ans;
    }
}
