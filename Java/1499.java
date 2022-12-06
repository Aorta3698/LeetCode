class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> deque = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int[] p : points){
            while(!deque.isEmpty() && p[0]-deque.peekFirst()[0]>k){
                deque.pollFirst();
            }
            if (!deque.isEmpty()){
                ans = Math.max(ans, p[0]-deque.peekFirst()[0]+p[1]+deque.peekFirst()[1]);
            }
            while(!deque.isEmpty() && p[1]-deque.peekLast()[1]-p[0]+deque.peekLast()[0]>=0){
                deque.pollLast();
            }
            deque.offerLast(p);
        }
        return ans;
    }
}
