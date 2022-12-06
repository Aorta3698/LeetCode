class FrontMiddleBackQueue {

    Item head, tail;
    int sz;

    public FrontMiddleBackQueue() {
        head = new Item(-1);
        tail = new Item(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void pushFront(int val) {
        Item item = new Item(val);
        item.prev = head;
        item.next = head.next;
        head.next.prev = item;
        head.next = item;
        sz++;
    }

    public void pushMiddle(int val) {
        Item cur = mid();
        Item item = new Item(val);
        item.next = cur.next;
        item.prev = cur;
        cur.next.prev = item;
        cur.next = item;
        sz++;
    }

    public void pushBack(int val) {
        Item item = new Item(val);
        item.next = tail;
        item.prev = tail.prev;
        tail.prev.next = item;
        tail.prev = item;
        sz++;
    }

    public int popFront() {
        if (sz == 0) return -1;
        sz--;
        int ret = head.next.val;
        head.next = head.next.next;
        head.next.prev = head;
        return ret;
    }

    public int popMiddle() {
        if (sz == 0) return -1;
        sz--;
        Item cur = mid();
        int ret = cur.next.val;
        cur.next = cur.next.next;
        cur.next.prev = cur;
        return ret;
    }

    public int popBack() {
        if (sz == 0) return -1;
        sz--;
        int ret = tail.prev.val;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return ret;
    }

    private Item mid(){
        Item cur = head;
        for (int i = 0; i < sz / 2; i++){
            cur = cur.next;
        }
        return cur;
    }

    private class Item{
        Item next;
        Item prev;
        int val;
        Item(int val){
            this.val = val;
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
