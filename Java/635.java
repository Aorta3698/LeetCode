https://leetcode.com/problems/design-log-storage-system/discuss/1859305/Java-or-Bit-and-TreeMap
class LogSystem {

    // 60 -> 1 << 6
    // 60 -> 1 << 6
    // 24 -> 1 << 5
    // 31 -> 1 << 5
    // 12 -> 1 << 4
    // 19 -> 1 << 5
    // bit sum = 31 -> an signed Integer is enough.

    TreeMap<Integer, List<Integer>> map;
    int[] bit;
    public LogSystem() {
        map = new TreeMap<>();
        bit = new int[]{26, 22, 17, 12, 6, 0};
    }

    public void put(int id, String timestamp) {
        map.computeIfAbsent(serialize(timestamp), o -> new ArrayList<>()).add(id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> ans = new ArrayList<>();
        int mask = switch(granularity){
            case "Year"   : yield (1 << bit[0]) - 1;
            case "Month"  : yield (1 << bit[1]) - 1;
            case "Day"    : yield (1 << bit[2]) - 1;
            case "Hour"   : yield (1 << bit[3]) - 1;
            case "Minute" : yield (1 << bit[4]) - 1;
            case "Second" : yield (1 << bit[5]) - 1;
            default       : yield -1;
        };
        int lo = serialize(start) & (~mask);
        int hi = serialize(end) | mask;
        Integer cur = map.floorKey(hi);

        while(cur != null && cur >= lo){
            ans.addAll(map.get(cur));
            cur = map.floorKey(cur - 1);
        }

        return ans;
    }

    private int serialize(String time){
        int ret = 0, i = 0;
        for (String t : time.split(":")){
            int n = Integer.parseInt(t);
            if (i == 0) {
                n -= 1999;
            }
            ret += n << bit[i++];
        }
        return ret;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
