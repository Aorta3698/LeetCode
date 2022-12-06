class MyQueue {
    private Stack<Integer> reverse;
    private Stack<Integer> normal;
    private int size;

    public MyQueue() {
        reverse = new Stack<>();
        normal = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        normal.push(x);
        size++;
    }

    public int pop() {
        if (!empty()){
            arrange();
            --size;

            return reverse.pop();
        }

        return -1;
    }

    public int peek() {
        if (!empty()){
            arrange();

            return reverse.peek();
        }

        return -1;
    }

    public boolean empty() {
        return size ==0;
    }

    private void arrange(){
        if (reverse.isEmpty())
            while(!normal.isEmpty())
                reverse.push(normal.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
