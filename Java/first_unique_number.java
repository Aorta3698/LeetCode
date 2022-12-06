class FirstUnique {

    HashMap<Integer, Integer> freq;
    Queue<Integer> queue;
    public FirstUnique(int[] nums) {
        freq = new HashMap<>();
        queue = new LinkedList<>();
        for (int n : nums) add(n);
    }

    public int showFirstUnique() {
        return queue.isEmpty()? -1 : queue.peek();
    }

    public void add(int value) {
        freq.merge(value, 1, Integer::sum);
        if (freq.get(value) == 1) queue.offer(value);
        removeDup();
    }

    private void removeDup(){
        while (!queue.isEmpty() && freq.get(queue.peek()) > 1) queue.poll();
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
