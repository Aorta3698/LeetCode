class CustomStack {

    int[] arr;
    int idx = 0;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (idx == arr.length) return;
        arr[idx++] = x;
    }

    public int pop() {
        if (idx == 0) return -1;

        return arr[--idx];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, arr.length); i++)
            arr[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
