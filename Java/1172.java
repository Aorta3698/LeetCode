class DinnerPlates {

    PriorityQueue<Node> minheap;
    Map<Integer, Node> map;
    int capacity;
    int top;
    public DinnerPlates(int capacity) {
        this.capacity=capacity;
        top = 0;
        Node node = new Node(top);
        map = new HashMap<>();
        map.put(top, node);
        minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o.idx));
        minheap.offer(node);
    }

    public void push(int val) {
        if (minheap.isEmpty()){
            Node node = new Node(++top);
            minheap.offer(node);
            map.put(top, node);
        }
        minheap.peek().stack.push(val);
        top=Math.max(top, minheap.peek().idx); // edge case
        if (minheap.peek().stack.size()==capacity){
            minheap.poll();
        }
    }

    public int pop() {
        return popAtStack(top);
    }

    public int popAtStack(int index) {
        if (index>top||map.get(index).stack.isEmpty()){
            return -1;
        }else{
            int res = map.get(index).stack.pop();
            while(map.get(top).stack.isEmpty()&&top>0){
                --top;
            }
            if (map.get(index).stack.size()==capacity-1){
                minheap.offer(map.get(index));
            }
            return res;
        }
    }

    private class Node {
        int idx;
        Deque<Integer> stack = new ArrayDeque<>();
        Node(int idx){
            this.idx=idx;
        }
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
