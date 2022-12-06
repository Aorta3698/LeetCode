class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> l;
    Random ran;

    public RandomizedSet() {
        map = new HashMap<>();
        l = new ArrayList<>();
        ran = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)){
            map.put(val, l.size());
            l.add(val);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)){
            int idx = map.get(val);
            l.set(idx, l.get(l.size()-1));
            map.put(l.get(idx), idx);
            l.remove(l.size()-1);
            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        return l.get(ran.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
