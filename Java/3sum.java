class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2 && nums[i] <= 0; i++){
            if (i != 0 && nums[i-1] == nums[i]) continue; //this line saves over 1100ms
            int left = i+1;
            int right = nums.length-1;
            while(right>left){
                if(left==i)left++;
                if(right==i)right--;
                if (nums[left]+nums[right] > -nums[i])right--;
                else if (nums[left]+nums[right] < -nums[i])left++;
                else if (left >= right) break;
                else{
                    List<Integer> l = Arrays.asList(nums[i], nums[left++], nums[right--]);
                    Collections.sort(l);
                    if(seen.add(l))ans.add(l);
                }
            }
        }

        return ans;
    }
}
