class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length, t = 0;
        int[] sign = new int[n + 1];
        int[] time = new int[n + 1];

        for (int i = 0; i < n; i++){
            if (time[i] > 0) continue;
            int cur = i;
            int neg = 0;
            int start = t;

            do{
                time[cur] = ++t;
                sign[t] = neg;
                cur = (cur + nums[cur] % n + n) % n;
                if (nums[cur] < 0){
                    neg++;
                }
            }while(time[cur] == 0);

            int sz = t - time[cur] + 1;
            int mcount = neg - sign[time[cur]];
            if (start < time[cur] && sz > 1 && (mcount == 0 || mcount == sz)){
                return true;
            }
        }

        return false;
    }
}
