class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int last = nums.length-1;
        for (int i = 0; i < last + 1; i++){
            if (nums[i] != val) continue;
            else {
                count++;
                while(i != last && nums[last]==val){last--;count++;}
                nums[i] = nums[last--];
            }
        }

        return nums.length - count;
    }
}
