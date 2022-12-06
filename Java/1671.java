class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++){
            if (list.isEmpty()||list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                int lo = 0, hi = list.size()-1;
                while(lo < hi){
                    int mid = (lo+hi)>>1;
                    if (list.get(mid)>=nums[i]){
                        hi=mid;
                    }else{
                        lo=mid+1;
                    }
                }
                list.set(lo,nums[i]);
            }
            dp[i]=list.size();
        }
        list.clear();
        int ans = dp[0];
        for (int i = nums.length-1; i > 0; i--){
             if (list.isEmpty()||list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
            }else{
                int lo = 0, hi = list.size()-1;
                while(lo < hi){
                    int mid = (lo+hi)>>1;
                    if (list.get(mid)>=nums[i]){
                        hi=mid;
                    }else{
                        lo=mid+1;
                    }
                }
                list.set(lo,nums[i]);
            }
            if (dp[i]>1&&list.size()>1){
                ans = Math.max(ans, list.size()+dp[i]);
            }
        }

        return nums.length-ans+1;
    }
}
