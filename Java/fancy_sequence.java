class Fancy {

    private static final int M = (int)1e9+7;
    private List<Integer> fancy;
    private List<Integer> other;
    private HashMap<Integer, Integer> map;
    public Fancy() {
        fancy = new ArrayList<>();
        other = new ArrayList<>();
        map = new HashMap<>();
    }

    public void append(int val) {
        fancy.add(val);
    }

    public void addAll(int inc) {
        other.add(inc);
        update();
    }

    public void multAll(int m) {
        other.add(m + 100);
        update();
    }

    public int getIndex(int idx) {
        if (idx >= fancy.size()) return -1;
        if (!map.containsKey(idx) || map.get(idx) == other.size()) return fancy.get(idx);

        int val = fancy.get(idx);
        for(int i = map.get(idx); i < other.size(); i++){
            int n = other.get(i);
            if (n > 100){
                long m = n - 100;
                long v = val;
                long p = m * v;
                val = p < M? (int)p : (int)(p % M);
                // val = (int)((m * v) % M);
            }
            else val += n;
        }

        fancy.set(idx, val);
        map.put(idx, other.size());
        return val;
    }

    private void update(){
        for (int i = fancy.size() - 1; i >= 0; i--){
            if (!map.containsKey(i))
                map.put(i, other.size() - 1);
            else
                break;
        }
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
