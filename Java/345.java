class Solution {
    public String reverseVowels(String s) {
        int lo = 0, hi = s.length() - 1;
        char[] arr = s.toCharArray();
        while(lo < hi){
            if (!isVowel(s.charAt(lo))) {lo++; continue;}
            if (!isVowel(s.charAt(hi))) {hi--; continue;}
            char tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++; hi--;
        }

        return String.valueOf(arr);
    }

    private static boolean isVowel(char ch){
        return "aeiou".contains(""+ch) || "AEIOU".contains(""+ch);
    }
}
