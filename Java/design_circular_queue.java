class MyCircularQueue {
    private int[] arr;
    private int head, tail;
    private int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        head = 0;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        size++;
        tail = (tail + 1) % arr.length;
        arr[tail] = value;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        head = (head + 1) % arr.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return arr[head];
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
