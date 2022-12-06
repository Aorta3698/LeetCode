class Solution {
    public String firstPalindrome(String[] words) {
        for (String w : words){
            int lo = 0, hi = w.length() - 1;
            int add = 1;
            while(lo < hi)
                if (w.charAt(lo++) != w.charAt(hi--) && --add == 0)
                    break;
            if (add == 1) return w;
        }

        return "";
    }
}
