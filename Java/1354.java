class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int n : target){
            maxheap.offer(1L*n);
            sum += n;
        }
        while(!maxheap.isEmpty() && maxheap.peek()>1){
            long cur = maxheap.poll();
            long rest = sum - cur;
            if (rest == 1)
                return true;
            if (rest == 0 || rest >= cur || cur % rest == 0)
                return false;
            long prev = cur % rest;
            sum = rest + prev;
            if (prev > 1){
                maxheap.offer(prev);
            }
        }

        return true;
    }
}
