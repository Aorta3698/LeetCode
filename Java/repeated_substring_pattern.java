class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length()/2; i++){
            int mul = s.length()/i;
            if (mul*i != s.length()) continue;

            String sub = s.substring(0, i);
            if(sub.repeat(mul).equals(s))
                return true;
        }

        return false;
    }
}
