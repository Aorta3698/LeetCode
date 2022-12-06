class MyHashMap {
    private List<Bucket> l;
    private static final int MOD = 10001;

    public MyHashMap() {
        l = new ArrayList<>();
        for (int i = 0; i < MOD; i++)
            l.add(new Bucket());
    }

    private int hash(int key){
        return key % MOD;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        l.get(hash).add(key, value);
    }

    public int get(int key){
        int hash = hash(key);
        return l.get(hash).get(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        l.get(hash).remove(key);
    }
}

class Bucket {
    private LinkedList<Pair> l;

    public Bucket(){
        l = new LinkedList<>();
    }

    private int getPair(int key){
        for (int i = 0; i < l.size(); i++){
            if (key == l.get(i).getKey())
                return i;
        }

        return -1;
    }

    public void add(int key, int value){
        int idx = getPair(key);
        if (idx != -1) l.get(idx).setValue(value);
        else l.add(new Pair(key, value));
    }

    public int get(int key){
        int idx = getPair(key);
        return idx == -1? -1 : l.get(idx).getValue();
    }

    public void remove(int key){
        int idx = getPair(key);
        if (idx != -1) l.remove(idx);
    }
}

class Pair{
    private int key;
    private int value;
    
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
