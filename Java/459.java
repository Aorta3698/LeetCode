class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i*i <= n && n != 1; i++){
            if (n%i==0 && s.substring(0, i).repeat(n/i).equals(s) || n/i!=n && s.substring(0, n/i).repeat(i).equals(s)){
                return true;
            }
        }
        return false;
    }
}
