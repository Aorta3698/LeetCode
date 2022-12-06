class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            if (!Character.isAlphabetic(arr[lo])) {lo++; continue;}
            if (!Character.isAlphabetic(arr[hi])) {hi--; continue;}

            char ch = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = ch;
            lo++; hi--;
        }

        return new String(arr);
    }
}
