class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] W) {
        int[] actual = new int[W.length];
        for (int i = 0, min = W[0]; i < W.length; i++){
            min = Math.min(W[i], min);
            actual[i] = min;
        }
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int j = W.length - 1, min = W[j]; j >= 0; j--){
            min = Math.min(W[j], min);
            minheap.offer(Math.max(min, actual[j]));
        }
        Arrays.sort(boxes);
        int ans = 0;
        while(!minheap.isEmpty()){
            if (boxes[ans] <= minheap.peek() && ++ans == boxes.length)
                break;
            minheap.poll();
        }
        return ans;
    }
}
