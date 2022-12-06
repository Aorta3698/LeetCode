class Solution {
    public int numSteps(String s) {
        int carry = 0, ans = 0;
        for (int i = s.length() - 1; i >= 1; i--){
            int sum = s.charAt(i) - '0' + carry;
            if (sum == 0){
                carry = 0;
            }else if (sum == 1){
                carry = 1;
                ans++;
            }else if (sum == 2){
                carry = 1;
            }
            ans++;
        }
        return ans + carry;
    }
}
