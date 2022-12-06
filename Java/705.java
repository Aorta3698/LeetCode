class MyHashSet {

    LinkedList<Integer>[] buckets;
    int sz;
    public MyHashSet() {
        sz = 4877;
        buckets = new LinkedList[sz];
        Arrays.setAll(buckets, o -> new LinkedList<>());
    }

    public void add(int key) {
        if (!contains(key)){
            buckets[hash(key)].add(key);
        }
    }

    public void remove(int key) {
        buckets[hash(key)].remove((Integer)key);
    }

    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }

    private int hash(int k){
        return k % sz;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
