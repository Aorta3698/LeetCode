class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> warehouse[o]));
        int pos = 0, ans = 0;
        for (; pos < warehouse.length && warehouse[pos] >= boxes[0]; pos++)
            minheap.offer(pos);

        if (minheap.isEmpty()) return 0;

        pos--;
        int i = 0;
        while(!minheap.isEmpty() && i < boxes.length && pos >= 0){
            if (minheap.peek() > pos){
                minheap.poll();
                continue;
            }

            if (warehouse[minheap.peek()] < boxes[i]) {
                pos = minheap.poll();
                continue;
            }

            if (warehouse[pos] >= boxes[i]){
                i++;
                ans++;
                pos--;
                continue;
            }

            pos--;
        }

        return ans;
    }
}
