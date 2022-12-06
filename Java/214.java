class Solution {
    public String shortestPalindrome(String s) {
        int M = 129, ans = 0;
        Set<Long> seen = new HashSet<>();
        long h = 0, m = 1;
        for (char ch : s.toCharArray()){
            h *= M;
            h += ch;
            seen.add(h);
        }
        h = 0;
        for (int i = 0; i < s.length(); i++){
            h += m*s.charAt(i);
            m*=M;
            if (seen.contains(h)){
                ans=i+1;
            }
        }
        return new StringBuilder(s.substring(ans)).reverse().toString() + s;
    }
}
