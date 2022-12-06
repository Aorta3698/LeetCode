class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p : piles){
            maxheap.offer(p);
        }
        while(--k >= 0){
            maxheap.offer((1+maxheap.poll()) / 2);
        }
        int ans = 0;
        for (int n : maxheap){
            ans += n;
        }
        return ans;
    }
}
