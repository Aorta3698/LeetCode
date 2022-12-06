class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int w : workers){
            map.merge(w, 1, Integer::sum);
        }
        Arrays.sort(tasks);
        int lo = 0, hi = tasks.length;
        while(lo < hi){
            var cur = (TreeMap<Integer, Integer>)map.clone();
            int mid = (lo+hi+1)>>1, cnt = 0;
            for (int i = mid-1; i >= 0; i--){
                Integer R = cur.ceilingKey(tasks[i]);
                if (R != null){
                    if (cur.merge(R, -1, Integer::sum) == 0){
                        cur.remove(R);
                    }
                }else{
                    cnt++;
                    R = cur.ceilingKey(tasks[i]-strength);
                    if (R == null || cnt > pills){
                        cnt=(int)1e9;
                        break;
                    }
                    if (cur.merge(R, -1, Integer::sum) == 0){
                        cur.remove(R);
                    }
                }
            }
            if (cnt <= pills){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
