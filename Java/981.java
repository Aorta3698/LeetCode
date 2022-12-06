class TimeMap {

    Map<String, List<Integer>> timeMap;
    Map<Integer, String> valMap;
    public TimeMap() {
        timeMap = new HashMap<>();
        valMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, o -> new ArrayList<>()).add(timestamp);
        valMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        List<Integer> list = timeMap.get(key);
        if (list == null) return "";

        int lo = 0, hi = list.size() - 1;
        while(lo < hi){
            int mid = (lo + hi + 1) / 2;
            if (list.get(mid) <= timestamp) lo = mid;
            else hi = mid - 1;
        }

        return list.get(lo) <= timestamp? valMap.get(list.get(lo)) : "";
    }
}

// class TimeMap {

//     TreeMap<String, TreeMap<Integer, String>> map;
//     public TimeMap() {
//         map = new TreeMap<>();
//     }

//     public void set(String key, String value, int timestamp) {
//         map.computeIfAbsent(key, o -> new TreeMap<>()).put(timestamp, value);
//     }

//     public String get(String key, int timestamp) {
//         if (!map.containsKey(key)) return "";
//         Integer ret = map.get(key).floorKey(timestamp);
//         return ret == null? "" : map.get(key).get(ret);
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
