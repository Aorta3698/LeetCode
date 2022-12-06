https://leetcode.com/problems/range-frequency-queries/discuss/1657618/Java-a-lame-solution-99-speed-somehow
class RangeFreqQuery {

    private Map<Integer, BitSet> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.computeIfAbsent(arr[i], o -> new BitSet()).set(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        if (map.size() == 1) return right - left + 1;
        return map.get(value).get(left, right + 1).cardinality();
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
