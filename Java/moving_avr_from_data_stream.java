class MovingAverage {

    private int size;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        if (queue.size() > size)
            queue.remove();

        double sum = 0;
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext())
            sum+=iter.next();
        
        return sum/Math.min(size, queue.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
