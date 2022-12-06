class Solution {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        for (int i = 0; i < n; i++){
            int remain = 26 * (n - i - 1);
            if (remain >= k - 1){
                ans[i] = 'a';
                k--;
            }else{
                ans[i] = (char)('a' - 1 + k - remain);
                k = remain;
            }
        }
        return String.valueOf(ans);
    }
}
