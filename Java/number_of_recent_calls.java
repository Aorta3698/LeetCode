class RecentCounter {

    private Deque<Integer> deque;

    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        deque.offer(t);
        while(deque.peekFirst() + 3000 < t) deque.pollFirst();
        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
