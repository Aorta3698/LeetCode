class Skiplist {

    Map<Integer, Integer> map;
    public Skiplist() {
        map = new HashMap<>();
    }
    
    public boolean search(int target) {
        return map.containsKey(target);
    }
    
    public void add(int num) {
        map.merge(num, 1, Integer::sum);
    }
    
    public boolean erase(int num) {
        if (!search(num)) return false;
        if (map.merge(num, -1, Integer::sum) == 0){
            map.remove(num);
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
