class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] i : matrix)
            for (int j : i){
                queue.offer(j);
                if (queue.size() > k)
                    queue.poll();
            }

        return queue.poll();
    }
}
