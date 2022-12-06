class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else {
            map.put(start == null || map.get(start) < left? left : start, Math.max(map.get(end), right));
        }
        map.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
    	if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
    	}
    	if (start != null && map.get(start) > left) {
            map.put(start, left);
    	}
        map.subMap(left, right).clear();
    }
}
