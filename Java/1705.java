https://leetcode.com/problems/maximum-number-of-eaten-apples/discuss/1915158/PriorityQueue-Storing-Index-Java
class Solution {
    public int eatenApples(int[] A, int[] D) {
        int ans = 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o + D[o]));

        for (int i = 0; !minheap.isEmpty() || i < A.length; i++){
            if (i < A.length && A[i] > 0){
                minheap.offer(i);
            }
            while(!minheap.isEmpty() && (i >= minheap.peek() + D[minheap.peek()] || A[minheap.peek()] == 0)){
                minheap.poll();
            }
            if (!minheap.isEmpty()){
                ans++;
                A[minheap.peek()]--;
            }
        }

        return ans;
    }
}
