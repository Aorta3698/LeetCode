class Solution {
    public String digitSum(String s, int k) {
        String ans = s;
        while(ans.length() > k){
            String next = "";
            int sum = 0;
            for (int i = 0; i < ans.length(); i++){
                sum += ans.charAt(i) - '0';
                if (i % k == k - 1 || i == ans.length() - 1){
                    next += ""+sum;
                    sum = 0;
                }
            }
            ans = next;
        }
        return ans;
    }
}
