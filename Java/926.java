class Solution {
    public int minFlipsMonoIncr(String s) {
        int one = 0, ans = 0;
        for (char ch : s.toCharArray()){
            if (ch == '1'){
                one++;
            }else{
                ans = Math.min(ans + 1, one);
            }
        }
        return ans;
    }
}
