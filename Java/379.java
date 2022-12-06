class PhoneDirectory {

    boolean[] used;
    Queue<Integer> queue;
    public PhoneDirectory(int maxNumbers) {
        used = new boolean[maxNumbers];
        queue = new ArrayDeque<>();
        for (int i = 0; i < maxNumbers; i++){
            queue.offer(i);
        }
    }

    public int get() {
        if (queue.isEmpty()) return -1;
        else{
            used[queue.peek()] = true;
            return queue.poll();
        }
    }

    public boolean check(int number) {
        return !used[number];
    }

    public void release(int number) {
        if (used[number]){
            used[number] = false;
            queue.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
