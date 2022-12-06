class Solution {
    public long appealSum(String s) {
        int[] last = new int[26];
        int[] llast = new int[26];
        for (int i = 0; i < 26; i++){
            last[i] = llast[i] = -1;
        }

        long ans = 0, count = 0;
        for (int i = 0; i < s.length(); i++){
            int a = last[s.charAt(i) - 'a'];
            int b = last[s.charAt(i) - 'a'];
            count += i - 2 * a + b;
            ans += count;
            llast[s.charAt(i) - 'a'] = last[s.charAt(i) - 'a'];
            last[s.charAt(i) - 'a'] = i;
        }
        return ans;
    }
}
