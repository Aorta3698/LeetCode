class Solution {
    public int findSubstringInWraproundString(String s) {
        int ans = 0, count = 0;
        int[] times = new int[26];

        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'a';
            if (i == 0 || (cur + 25) % 26 != s.charAt(i - 1) - 'a'){
                count = 0;
            }
            ans += Math.max(++count - times[cur], 0);
            times[cur] = Math.max(times[cur], count);
        }

        return ans;
    }
}
