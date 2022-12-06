class MyHashMap {

    int M = 4611;
    LinkedList<Item>[] arr;
    public MyHashMap() {
        arr = new LinkedList[M];
        Arrays.setAll(arr, o -> new LinkedList<>());
    }

    public void put(int key, int value) {
        LinkedList<Item> cur = arr[id(key)];
        int idx = findIdx(cur, key);
        if (idx == -1){
            cur.add(new Item(key, value));
        }else{
            cur.get(idx).val = value;
        }
    }

    public int get(int key) {
        LinkedList<Item> cur = arr[id(key)];
        int idx = findIdx(cur, key);
        return idx == -1? -1: cur.get(idx).val;
    }

    public void remove(int key) {
        LinkedList<Item> cur = arr[id(key)];
        int idx = findIdx(cur, key);
        if (idx != -1){
            cur.remove(idx);
        }
    }

    private int findIdx(LinkedList<Item> cur, int key){
        for (int i = 0; i < cur.size(); i++){
            if (cur.get(i).key == key){
                return i;
            }
        }
        return -1;
    }

    private int id(int key){
        return key % M;
    }

    private class Item {
        int key;
        int val;
        Item (int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
