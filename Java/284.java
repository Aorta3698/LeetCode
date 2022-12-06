class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    public PeekingIterator(Iterator<Integer> iterator) {
        queue = new ArrayDeque<>();
        while(iterator.hasNext()){
            queue.offer(iterator.next());
        }
    }

    public Integer peek() {
        return queue.peek();
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
