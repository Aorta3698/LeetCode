class MaxStack {

    private int id;
    private Set<Integer> removeSet;
    private Deque<Integer> stack;
    private TreeMap<Integer, LinkedList<Integer>> maxMap;
    private Map<Integer, Integer> map;
    public MaxStack() {
        id = 0;
        removeSet = new HashSet<>();
        stack = new ArrayDeque<>();
        maxMap = new TreeMap<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        stack.push(id);
        maxMap.computeIfAbsent(x, o -> new LinkedList<>()).add(id);
        map.put(id, x);
        id++;
    }

    public int pop() {
        updateStack();
        removeSet.add(stack.peek());
        return map.get(stack.pop());
    }

    public int top() {
        updateStack();
        return map.get(stack.peek());
    }

    public int peekMax() {
        updateHeap();
        return maxMap.lastKey();
    }

    public int popMax() {
        removeSet.add(updateHeap());
        return maxMap.lastKey();
    }

    private void updateStack(){
        while(removeSet.contains(stack.peek()))
            stack.poll();
    }

    private int updateHeap(){
        int i = -1;
        while(i == -1){
            int max = maxMap.lastKey();
            for (int j : maxMap.get(max))
                if (!removeSet.contains(j))
                    i = j;
            if (i == -1) maxMap.remove(max);
        }

        return i;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
