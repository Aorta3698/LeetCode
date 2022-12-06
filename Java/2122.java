class Solution {
    public int[] recoverArray(int[] nums) {
        Map<Integer, Integer>[] map = new HashMap[2];
        Arrays.setAll(map, o->new HashMap<>());
        Arrays.sort(nums);
        for (int n : nums){
            map[n&1].merge(n,1,Integer::sum);
        }
        int[] ans = new int[nums.length/2];
        for (int key : map[nums[0]&1].keySet()){
            if (key != nums[0] && solve(0,0,Math.abs(key-nums[0]),nums,ans,map)){
                break;
            }
        }
        return ans;
    }

    private boolean solve(int idx, int k, int diff, int[] nums, int[] ans, Map<Integer, Integer>[] map){
        if (k==ans.length){
            return true;
        }
        Map<Integer, Integer> cur = map[nums[idx]&1];
        if (cur.get(nums[idx])==0){
            return solve(idx+1,k,diff,nums,ans,map);
        }
        cur.merge(nums[idx],-1,Integer::sum);
        int val = nums[idx]+diff;
        if (cur.getOrDefault(val, 0)>0){
            cur.merge(val,-1,Integer::sum);
            ans[k]=(nums[idx]+val)/2;
            if (solve(idx+1,k+1,diff,nums,ans,map)){
                return true;
            }
            cur.merge(val,1,Integer::sum);
        }
        cur.merge(nums[idx],1,Integer::sum);
        return false;
    }
}
