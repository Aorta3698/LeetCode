class SnapshotArray {

    int id;
    TreeMap<Integer, Integer>[] arr;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        Arrays.setAll(arr, o -> new TreeMap<>(Map.of(-1, 0)));
        id = 0;
    }

    public void set(int index, int val) {
        arr[index].put(id, val);
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        return arr[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
