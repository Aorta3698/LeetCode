https://leetcode.com/problems/wiggle-sort-ii/discuss/1945315/Java-or-PriorityQueue-5-lines
class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums){
            maxheap.offer(n);
        }
        for (int i = 1; i < nums.length; i+=2){
            nums[i] = maxheap.poll();
        }
        for (int i = 0; i < nums.length; i+=2){
            nums[i] = maxheap.poll();
        }
    }
}
