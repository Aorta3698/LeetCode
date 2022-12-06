class Solution {
    public String breakPalindrome(String P) {
        if (P.length() == 1)
            return "";
        for (int i = 0; i < P.length(); i++){
            if (P.charAt(i) == 'a' || P.length() % 2 == 1 && i == P.length()/2)
                continue;
            return P.substring(0, i) + "a" + P.substring(i + 1);
        }
        return P.substring(0, P.length() - 1) + "b";
    }
}
