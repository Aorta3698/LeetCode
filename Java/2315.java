class Solution {
    public int countAsterisks(String s) {
        int ans = 0;
        int pipe = 0;
        for (char ch : s.toCharArray()){
            if (ch == '|'){
                pipe^=1;
            }
            if (pipe == 0 && ch == '*'){
                ans++;
            }
        }
        return ans;
    }
}
