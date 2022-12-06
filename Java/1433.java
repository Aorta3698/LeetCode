class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] pre1 = count(s1);
        int[] pre2 = count(s2);
        int n = s1.length();
        return check(pre1, pre2, n) || check(pre2, pre1, n);
    }

    private static int[] count(String s){
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        for (int i = 0; cnt[i] < s.length(); i++) cnt[i + 1] += cnt[i];
        return cnt;
    }

    private static boolean check(int[] a, int[] b, int n){
        for (int i = 0; a[i] < n; i++)
            if (a[i] < b[i])
                return false;
        return true;
    }
}
