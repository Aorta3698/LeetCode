class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums){
            int lo = 0, hi = list.size();
            while(lo < hi){
                int mid = (lo+hi)>>1;
                if (list.get(mid)>=n){
                    hi=mid;
                }else{
                    lo=mid+1;
                }
            }
            if (lo == list.size()){
                list.add(n);
            }else{
                list.set(lo, n);
            }
        }
        return list.size();
    }
}
