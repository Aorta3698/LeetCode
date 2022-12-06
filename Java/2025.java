class Solution {
    public int waysToPartition(int[] nums, int k) {
        long pre = 0;
        long suf = Arrays.stream(nums).asLongStream().sum();
        Map<Long, List<Integer>> preMap = new HashMap<>();
        Map<Long, List<Integer>> sufMap = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++){
            pre += nums[i];
            suf -= nums[i];
            preMap.computeIfAbsent(pre-suf, o -> new ArrayList<>()).add(i); // excluded i (or write i+1, then change >= to > in the binary search)
            sufMap.computeIfAbsent(suf-pre, o -> new ArrayList<>()).add(i); // included i
        }

        int ans = preMap.getOrDefault(0L, List.of()).size();
        for (int i = 0; i < nums.length; i++){
            int d = k-nums[i], count = 0;
            List<Integer> preList = preMap.getOrDefault(0L+d, List.of());
            List<Integer> sufList = sufMap.getOrDefault(0L+d, List.of());
            int lo = 0, hi = preList.size();
            while(lo < hi){ // excluded ...)
                int mid = (lo+hi)>>1;
                if (preList.get(mid)>=i){
                    hi=mid;
                }else{
                    lo=mid+1;
                }
            }
            count += lo;
            lo = -1; hi = sufList.size()-1;
            while(lo < hi){ // included [...
                int mid = (lo+hi+1)>>1;
                if (sufList.get(mid)<i){
                    lo=mid;
                }else{
                    hi=mid-1;
                }
            }
            ans = Math.max(ans, count+sufList.size()-1-lo);
        }

        return ans;
    }
}
