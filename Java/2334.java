https://leetcode.com/problems/subarray-with-elements-greater-than-varying-threshold/discuss/2260718/Java-or-Heap-and-TreeSet-or-Concise-and-Easy
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n  = nums.length;
        int[] min = new int[n];
        TreeSet<Integer> dead = new TreeSet<>(Set.of(n, -1)); // base case
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.comparingInt(o -> -min[o]));
        for (int i = 0; i < n; i++){
            min[i]=threshold/nums[i]+1;
            if (min[i]>nums.length){
                dead.add(i); // dead, this element should never appear in the answer
            }else{
                maxheap.offer(i);
            }
        }
        while(!maxheap.isEmpty()){
            int cur = maxheap.poll();
            if (dead.higher(cur)-dead.lower(cur)-1<min[cur]){
                dead.add(cur);  // widest open range < minimum required length, this index is also bad.
            }else{
                return min[cur]; // otherwise we've found it!
            }
        }
        return -1;
    }
}
