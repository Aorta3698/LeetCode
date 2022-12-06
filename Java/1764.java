class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++){
            if (nums[i] == groups[j][0] && i + groups[j].length <= nums.length){
                for (int k = i; k - i < groups[j].length; k++){
                    if (nums[k] != groups[j][k - i])
                        break;
                    if (k - i == groups[j].length - 1){
                        i += groups[j].length - 1;
                        if (++j == groups.length)
                            return true;
                        break;
                    }
                }
            }
        }
        return false;
    }
}
