class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 0; i < obstacles.length; i++){
            int lo = 0, hi = list.size();
            while(lo < hi){
                int mid = (lo+hi)>>1;
                if (list.get(mid) > obstacles[i]){
                    hi=mid;
                }else{
                    lo=mid+1;
                }
            }
            if (lo == list.size()){
                list.add(obstacles[i]);
            }else{
                list.set(lo, obstacles[i]);
            }
            ans[i]=lo+1;
        }
        return ans;
    }
}
