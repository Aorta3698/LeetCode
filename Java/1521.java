class Solution {
    public int closestToTarget(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        for (int n : arr){
            Set<Integer> next = new HashSet<>();
            for (int nn : set){
                next.add(n&nn);
            }
            next.add(n);
            all.addAll(next);
            set=next;
        }
        List<Integer> got = new ArrayList<>(all);
        Collections.sort(got);
        int lo = -1, hi = got.size()-1;
        while(lo < hi){
            int mid = (lo+hi+1) >> 1;
            if (got.get(mid) < target){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        if (lo == -1){
            return got.get(0) - target;
        }else if (lo == got.size() - 1){
            return target - got.get(lo);
        }
        return Math.min(target-got.get(lo), got.get(lo+1)-target);
    }
}
