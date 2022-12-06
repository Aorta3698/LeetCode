class Solution {
    public int longestAwesome(String s) {
        int[] where = new int[1<<10];
        Arrays.fill(where, s.length());
        where[0]=-1;
        int cur = 0, ans = 0;
        for (int i = 0; i < s.length();i++){
            cur^=1<<(s.charAt(i)-'0');
            ans = Math.max(ans, i - where[cur]);
            for (int j = 0; j < 10; j++){
                ans=Math.max(ans, i-where[cur^1<<j]);
            }
            where[cur] = Math.min(i, where[cur]);
        }
        return ans;
    }
}
