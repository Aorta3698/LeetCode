class MyCircularDeque {

    private A head;
    private A tail;
    int sz = 0;
    int max = 0;

    public MyCircularDeque(int k) {
        max = k;
        head = tail = null;
    }

    public boolean insertFront(int value) {
        if (sz >= max) return false;
        ++sz;

        A cur = new A(value);
        if (head == null){
            head = cur;
        }else{
            head.prev = cur;
            cur.next = head;
            head = cur;
        }

        if (tail == null){
            tail = cur;
        }

        return true;
    }

    public boolean insertLast(int value) {
        if (sz >= max) return false;
        ++sz;

        A cur = new A(value);
        if (tail == null){
            tail = cur;
        }else{
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }

        if (head == null){
            head = cur;
        }

        return true;
    }

    public boolean deleteFront() {
        if (sz == 0) return false;
        --sz;

        if (tail == head){
            head = tail = null;
        }else{
            head = head.next;
        }
        return true;
    }

    public boolean deleteLast() {
        if (sz == 0) return false;
        --sz;

        if (tail == head){
            head = tail = null;
        }else{
            tail = tail.prev;
        }
        return true;
    }

    public int getFront() {
        return sz <= 0? -1 : head.val;
    }

    public int getRear() {
        return sz <= 0? -1 : tail.val;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public boolean isFull() {
        return sz == max;
    }

    private class A{
        A next;
        A prev;
        int val;
        A(int val){
            this.val = val;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
