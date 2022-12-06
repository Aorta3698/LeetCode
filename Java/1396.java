https://leetcode.com/problems/design-underground-system/discuss/1977429/Java-or-2-Maps-or-Concise
class UndergroundSystem {

    Map<Integer, Map.Entry<String, Integer>> in;
    Map<String, Map<String, int[]>> map;
    public UndergroundSystem() {
        in = new HashMap<>();
        map= new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        in.put(id, Map.entry(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Map.Entry<String, Integer> val = in.remove(id);
        int[] data = map.computeIfAbsent(val.getKey(), o -> new HashMap<>())
                        .computeIfAbsent(stationName, o -> new int[2]);
        data[1]++;
        data[0] += t - val.getValue();
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] data = map.get(startStation).get(endStation);
        return 1d * data[0] / data[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
