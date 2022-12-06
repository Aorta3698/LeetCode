class Solution {
    public int countGoodSubstrings(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        int dup = 0;
        for (int i = 0; i < Math.min(s.length(), 3); i++)
            if (++count[arr[i] - 'a'] == 2)
                ++dup;

        int ans = dup == 0 && s.length() >= 3? 1 : 0;
        for (int i = 3; i < arr.length; i++){
            if (++count[arr[i] - 'a'] == 2) dup++;
            if (--count[arr[i - 3] - 'a'] == 1) dup--;
            if (dup == 0) ans++;
        }

        return ans;
    }
}
