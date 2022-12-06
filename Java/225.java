class MyStack {

    Queue<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        findTop();
        return queue.poll();
    }

    public int top() {
        findTop();
        int ans = queue.peek();
        queue.offer(queue.poll());
        return ans;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void findTop(){
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
