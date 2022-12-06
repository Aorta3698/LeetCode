class MyHashSet {
    private List<Bucket> l;
    private static final int MOD = 2011;

    public MyHashSet() {
        l = new ArrayList<>();
        for (int i = 0; i < MOD; i++)
            l.add(new Bucket());
    }

    private int hash(int key){
        return key % MOD;
    }

    public void add(int key) {
        int hash = hash(key);
        l.get(hash).add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        l.get(hash).remove(key);
    }

    public boolean contains(int key) {
        int hash = hash(key);
        return l.get(hash).contains(key);
    }
}

class Bucket {
    private LinkedList<Integer> l;

    public Bucket(){
        l = new LinkedList<>();
    }

    public boolean add(int val){
        int idx = l.indexOf(val);
        if (idx == -1) l.add(val);
        return idx != -1;
    }

    public boolean remove(int val){
        return l.remove((Integer)val);
    }

    public boolean contains(int val){
        return l.contains(val);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
