class MajorityChecker {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();
    int[] arr;
    public MajorityChecker(int[] arr) {
        this.arr=arr;
        for (int i = 0; i < arr.length; i++){
            map.computeIfAbsent(arr[i], o -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int threshold) {
        ++right;
        for (int i = 0; i < 20; i++){
            int idx = random.nextInt(left, right);
            List<Integer> cur = map.get(arr[idx]);
            if (bs(right, cur)-bs(left, cur)>=threshold){
                return arr[idx];
            }
        }

        return -1;
    }

    private int bs(int n, List<Integer> cur){
        int lo = 0, hi = cur.size();
        while(lo < hi){
            int mid = (lo+hi) >> 1;
            if (cur.get(mid)>=n){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
