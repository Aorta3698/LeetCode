class MyStack {
    private Queue<Integer> regular;
    private int size;
    boolean needToRearrange;

    public MyStack() {
        regular = new LinkedList<>();
        size = 0;
        needToRearrange = true;
    }

    public void push(int x) {
       ++size;
       regular.offer(x);
       needToRearrange = true;
    }

    public int pop() {
        if (!empty()){
            if(needToRearrange) rearrange();
            needToRearrange = true;
            --size;
            return regular.poll();
        }

        return -1;
    }

    public int top() {
        if (!empty()){
            if(needToRearrange) rearrange();
            needToRearrange = false;
            return regular.peek();
        }

        return -1;
    }

    public boolean empty() {
        return size ==0;
    }

    private void rearrange(){
        for (int i = 0; i < size-1;i++)
            regular.offer(regular.poll());
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
