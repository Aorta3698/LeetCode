https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/2316656/Java-or-Bottom-up-DP-or-O(2n)
class Solution {
    public int maxLength(List<String> arr) {
        String[] words = arr.stream().filter(o -> o.chars().distinct().count() == o.length()).toArray(String[]::new);
        int[] dp = new int[1<<words.length];
        int[] ok = new int[1<<words.length];
        for (int i = 0; i < words.length; i++){
            for (char ch : words[i].toCharArray()){
                ok[1<<i]|=1<<(ch-'a');
                dp[1<<i]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++){
            if ((ok[i&(i-1)]&ok[i&-i])==0){
                dp[i] = dp[i&(i-1)] + dp[i&-i];
                ok[i] = ok[i&(i-1)] | ok[i&-i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}


class Solution {
    public int maxLength(List<String> arr) {
        int[] bit = new int[arr.size()];
        for (int i = 0; i < bit.length; i++){
            int cur = 0;
            for (int j = 0; j < arr.get(i).length(); j++){
                int n = 1 << (arr.get(i).charAt(j) - 'a');
                if ((cur & n) > 0){
                    cur = 0;
                    break;
                }
                cur |= n;
            }
            bit[i] = cur;
        }
        return solve(0, 0, bit);
    }

    private int solve(int i, int cur, int[] bit){
        if (i == bit.length)
            return Integer.bitCount(cur);
        int ans = solve(i + 1, cur, bit);
        if ((bit[i] & cur) == 0){
            ans = Math.max(ans, solve(i + 1, cur | bit[i], bit));
        }
        return ans;
    }
}
