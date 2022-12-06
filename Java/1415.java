https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/discuss/1648100/Java-BackTracking-1MS-99-Speed-and-Mem-6-Lines-with-comments
class Solution {
    public String getHappyString(int n, int k) {
        char[] ans = new char[n];
        return gen(0, k, ans) != 0? "" : String.valueOf(ans);
    }

    private static int gen(int idx, int k, char[] arr){
        if (idx == arr.length) return k - 1;

        for (int i = 0; i < 3 && k != 0; i++)
            if (idx == 0 || arr[idx - 1] - 'a' != i){
                arr[idx] = (char)('a' + i);
                k = gen(idx + 1, k, arr);
            }

        return k;
    }
}
