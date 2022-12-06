https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/1660709/Java-or-Concise-One-Pass-Queue-Solution
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0, prev = -1; i < n; i++){
            if (nums[i] % 2 == 1) {
                queue.offer(i);
            }
            if (queue.size() == k){
                int next = i + 1, cur = queue.poll();
                while(next < n && nums[next] % 2 == 0) next++;
                ans += (next - i) * (cur - prev);
                i = next - 1;
                prev = cur;
            }
        }

        return ans;
    }
}
