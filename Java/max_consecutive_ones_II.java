class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < nums.length; i++){
            if (nums[i]==1) count++;
            else{
                max = Math.max(max, stack.pop()+count+1);
                stack.push(count);
                count = 0;
            }

            if (i == nums.length-1 && count > 0)
                max = Math.max(max, stack.pop()+count+1);
        }

        return Math.min(nums.length, max);
    }
}
