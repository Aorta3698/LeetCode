class LRUCache {

    Map<Integer, Item> map;
    Item dummyHead;
    Item dummyTail;
    int max;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dummyHead = new Item();
        dummyTail = new Item();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        max = capacity;
    }

    public int get(int key) {
        return map.containsKey(key)? moveFirst(map.get(key)) : -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.get(key).val = value;
        }else{
            map.put(key, new Item(key, value));
            if (map.size() > max){
                map.remove(dummyTail.prev.key);
                dummyTail.prev = dummyTail.prev.prev;
                dummyTail.prev.next = dummyTail;
            }
        }
        moveFirst(map.get(key));
    }

    private int moveFirst(Item cur){
        if (cur.prev != null){
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        cur.prev = dummyHead;
        cur.next = dummyHead.next;
        cur.next.prev = cur;
        dummyHead.next = cur;
        return cur.val;
    }

    private class Item {
        Item next;
        Item prev;
        int val;
        int key;
        Item () {}
        Item (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
