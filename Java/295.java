class MedianFinder {

    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (minheap.isEmpty())
            minheap.offer(num);
        else if (minheap.size() >= maxheap.size()){
            if (num > minheap.peek()){
                maxheap.offer(minheap.poll());
                minheap.offer(num);
            }else
                maxheap.offer(num);
        }else{
            if (num < maxheap.peek()){
                minheap.offer(maxheap.poll());
                maxheap.offer(num);
            }else
                minheap.offer(num);
        }
    }

    public double findMedian() {
        if (maxheap.isEmpty()) return minheap.peek();
        if (maxheap.size() == minheap.size()) return (double)(maxheap.peek() + minheap.peek()) / 2;
        return minheap.size() > maxheap.size()? minheap.peek() : maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
