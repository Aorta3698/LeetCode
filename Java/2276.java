class CountIntervals {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int count = 0;
    public CountIntervals() {

    }

    public void add(int left, int right) {
        Integer l = map.floorKey(left);
        Integer r = map.floorKey(right);
        left = l == null || map.get(l) < left? left : l;
        right = Math.max(right, r == null? 0 : map.get(r));
        Map<Integer, Integer> dup = map.subMap(left, true, right, true);
        for (int key : dup.keySet()){
            count -= (map.get(key)-key+1);
        }
        dup.clear();
        map.put(left, right);
        count += (right - left + 1);
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
