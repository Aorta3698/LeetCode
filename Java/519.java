class Solution {

    Random random;
    Map<Integer, Integer> map; // blacklist -> whitelist, Fisher-Yates
    int m, n, last;
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        random = new Random();
        map = new HashMap<>();
        last = m * n;
    }

    public int[] flip() {
        int val = random.nextInt(last--);
        int ret = map.getOrDefault(val, val);
        map.put(val, map.getOrDefault(last, last));
        // int ret = val;
        // while (map.containsKey(ret)){
        //     ret = map.get(ret);
        // }
        // map.put(val, last);

        return new int[]{ret / n, ret % n};
    }

    public void reset() {
        map.clear();
        last = n * m;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
