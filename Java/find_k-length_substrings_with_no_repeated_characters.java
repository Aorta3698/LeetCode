https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/discuss/1632411/java-sliding-window-array-10-lines
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        int dup = 0;
        for (int i = 0; i < k; i++) if (++count[arr[i] - 'a'] == 2) ++dup;
        int ans = dup > 0? 0 : 1;

        for (int i = k; i < arr.length; ++i){
            if (++count[arr[i] - 'a'] == 2) ++dup;
            if (--count[arr[i - k] - 'a'] == 1) --dup;
            if (dup == 0) ans++;
        }

        return ans;
    }
}
