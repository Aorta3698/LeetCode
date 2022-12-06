class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] right = new int[nums.length];
        int[] left  = new int[nums.length];
        Arrays.fill(right, nums.length);
        Arrays.fill(left,  -1);
        Deque<Integer> rs = new ArrayDeque<>();
        Deque<Integer> ls = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            while(!rs.isEmpty() && nums[i]<nums[rs.peek()]){
                right[rs.pop()]=i;
            }
            while(!ls.isEmpty() && nums[j]<nums[ls.peek()]){
                left[ls.pop()]=j;
            }
            rs.push(i);
            ls.push(j);
        }
        for (int i = 0; i < nums.length; i++){
            if (right[i]>k&&k>left[i]){
                ans = Math.max(ans, (right[i]-left[i]-1)*nums[i]);
            }
        }
        return ans;
    }
}
