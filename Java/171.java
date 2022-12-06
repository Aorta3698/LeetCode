class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (char ch : columnTitle.toCharArray()){
            ans *= 26;
            ans += ch - 'A' + 1;
        }

        return ans;
    }
}
