https://leetcode.com/problems/design-underground-system/discuss/1634788/Java-or-99-Speed-With-HashCode-and-Map
class UndergroundSystem {

    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> count;
    private HashMap<Integer, Integer> check;
    private HashMap<Integer, Integer> station;
    public UndergroundSystem() {
        map = new HashMap<>();
        check = new HashMap<>();
        count = new HashMap<>();
        station = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        check.put(id, t);
        station.put(id, stationName.hashCode());
    }

    public void checkOut(int id, String stationName, int t) {
        int time = check.get(id);
        int from = station.get(id);
        int hash = from * 7 + stationName.hashCode();
        count.merge(hash, 1, Integer::sum);
        map.merge(hash, t - time, Integer::sum);
    }

    public double getAverageTime(String startStation, String endStation) {
        int hash = startStation.hashCode() * 7 + endStation.hashCode();
        return (double)map.get(hash) / count.get(hash);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
