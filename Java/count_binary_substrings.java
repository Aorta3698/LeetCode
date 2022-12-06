https://leetcode.com/problems/count-binary-substrings/discuss/1637133/Java-or-5-lines-or-O(n)-one-pass-100-Speed-or-Explained.
class Solution {
    public int countBinarySubstrings(String s) {
        int start = 0, ans = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != arr[i - 1]){ans++; start = i - 1;}
            else if (start > 0 && arr[--start] != arr[i]) ans++;
            else start = 0;
        }

        return ans;
    }
}
