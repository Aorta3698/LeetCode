class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        maxheap.offer(0);
        for (int i = 0; i < mat.length; i++){
            PriorityQueue<Integer> next = new PriorityQueue<>();
            for (int cur : maxheap){
                for (int j = 0; j < mat[i].length; j++){
                    next.offer(cur - mat[i][j]);
                    if (next.size() > k){
                        next.poll();
                    }
                }
            }
            maxheap = next;
        }
        return -maxheap.poll();
    }
}
