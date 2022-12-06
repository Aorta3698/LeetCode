class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        return (int)getNum(d, f, target, new HashMap<>());
    }

    private long getNum(int d, int f, int target,
            HashMap<Map.Entry<Integer, Integer>, Long> map){

        if (target <= 0 || d*f < target) return 0;
        if (d == 1) return 1;
        if (map.containsKey(Map.entry(d, target))) return map.get(Map.entry(d, target));
        long sum = 0;
        for (int i = 1; i <= f; i++){
            sum += getNum(d - 1, f, target - i, map);
            sum %= (int)(1e9 + 7);
        }

        map.put(Map.entry(d, target), sum);
        return sum;
    }
}
