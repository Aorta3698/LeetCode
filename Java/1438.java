class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        for (; i < nums.length; i++){
            while(!max.isEmpty() && nums[i] > nums[max.peekLast()]){
                max.pollLast();
            }
            while(!min.isEmpty() && nums[i] < nums[min.peekLast()]){
                min.pollLast();
            }
            max.offerLast(i);
            min.offerLast(i);
            if (nums[max.peekFirst()] - nums[min.peekFirst()] > limit){
                j++;
            }
            if (j > min.peekFirst()){
                min.pollFirst();
            }
            if (j > max.peekFirst()){
                max.pollFirst();
            }
        }
        return i - j;
    }
}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0, max = nums[0], min = max;
        for (; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            map.merge(nums[i], 1, Integer::sum);
            if (max - min > limit && map.merge(nums[j++], -1, Integer::sum) == 0){
                map.remove(nums[j - 1]);
                min = map.firstKey();
                max = map.lastKey();
            }
        }

        return i - j;
    }
}
