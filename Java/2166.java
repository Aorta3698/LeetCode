class Bitset {

    int[] arr;
    int f, set;
    public Bitset(int size) {
        arr = new int[size];
        f = set = 0;
    }

    public void fix(int idx) {
        if ((arr[idx] + f) % 2 == 0) {
            set++;
            arr[idx] = 1 - arr[idx];
        }
    }

    public void unfix(int idx) {
        if ((arr[idx] + f) % 2 == 1) {
            set--;
            arr[idx] = 1 - arr[idx];
        }
    }

    public void flip() {
        f = (f + 1) & 1;
        set = arr.length - set;
    }

    public boolean all() {
        return set == arr.length;
    }

    public boolean one() {
        return set > 0;
    }

    public int count() {
        return set;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int n : arr){
            sb.append((n + f) % 2);
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
