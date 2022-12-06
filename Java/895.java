class FreqStack {

    int time;
    TreeMap<Integer, TreeSet<Item>> data;
    Map<Integer, Item> map;
    Comparator<Item> cmp = Comparator.comparingInt(o -> o.stack.peek());

    public FreqStack() {
        data = new TreeMap<>();
        map = new HashMap<>();
    }

    public void push(int val) {
        Item cur = map.getOrDefault(val, new Item(val));
        map.put(val, cur);
        move(cur.stack.size(), cur, 1);
    }

    public int pop() {
        int freq = data.lastKey();
        Item cur = data.get(freq).last();
        move(freq, cur, -1);

        return cur.val;
    }

    private void move(int freq, Item cur, int dist){
        TreeSet<Item> old = data.get(freq);
        if (old != null && old.size() == 1){
            data.remove(freq);
        }else if (old != null){
            old.remove(cur);
        }

        if (dist == 1){
            cur.stack.push(time++);
        }else{
            cur.stack.pop();
        }

        if (freq + dist > 0){
            data.computeIfAbsent(freq + dist, o -> new TreeSet<>(cmp)).add(cur);
        }
    }

    private class Item{
        int val;
        Deque<Integer> stack = new ArrayDeque<>();
        Item(int val){
            this.val = val;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
