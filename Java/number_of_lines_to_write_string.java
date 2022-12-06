class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        ans[0] = 1;
        int sum = 0;
        for (char ch : s.toCharArray()){
            if (sum + widths[ch - 'a'] > 100){
                sum = 0;
                ans[0]++;
            }

            sum += widths[ch - 'a'];
        }

        ans[1] = sum;
        return ans;
    }
}
