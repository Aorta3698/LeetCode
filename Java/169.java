class Solution {
    public int majorityElement(int[] nums) {
        int cur = 0, cnt = 0;
        for (int n : nums){
            if (cnt == 0) cur = n;
            if (cur == n) cnt++;
            else cnt--;
        }

        cnt = 0;
        for (int n : nums) if (n == cur) cnt++;
        return cnt > nums.length / 2? cur : -1;

        // return cur;
    }
}
