class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int ans = 0;
        for (char ch : s.toCharArray()){
            if (ch == 'R') count++;
            else count--;

            if (count == 0) ans++;
        }

        return ans;
    }
}
