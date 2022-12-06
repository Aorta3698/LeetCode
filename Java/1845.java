class SeatManager {

    private PriorityQueue<Integer> minheap;
    public SeatManager(int n) {
        minheap = new PriorityQueue<>();
        minheap.offer(1);
    }

    public int reserve() {
        int get = minheap.poll();
        if (minheap.isEmpty()) minheap.offer(get + 1);
        return get;
    }

    public void unreserve(int seatNumber) {
        minheap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
