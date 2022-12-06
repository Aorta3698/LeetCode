class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            sb.append(nums[i]);
            if (i < n - 1) sb.append('/');
            if (i == 0 && n > 2){
                sb.append('(');
            }
        }
        if (n > 2){
            sb.append(")");
        }
        return sb.toString();
    }
}
