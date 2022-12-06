class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[128];
        int ans = 0, max = 0, n = s.length();
        for (int i = 0; i < n; i++){
            max = Math.max(++cnt[s.charAt(i)], max);
            if (ans - max < k) {
                ans++;
            }else{
                cnt[s.charAt(i - ans)]--;
            }
        }

        return ans;
    }
}
