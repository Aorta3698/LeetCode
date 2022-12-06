class Solution {
    public int minTimeToType(String word) {
        int ans = word.length();
        char prev = 'a';
        for (char ch : word.toCharArray()){
            int d = Math.abs(ch - prev);
            ans += Math.min(d, 26 - d);
            prev = ch;
        }

        return ans;
    }
}
