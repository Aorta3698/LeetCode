class Solution {
    public int maxScore(String s) {
        int one = 0, ans = 0, zero = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                one++;
        for (int i = 0; i < s.length() - 1; i++){
            char ch = s.charAt(i);
            if (ch == '0') ++zero;
            if (ch == '1') --one;
            ans = Math.max(zero + one, ans);
        }

        return ans;
    }
}
