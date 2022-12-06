class MRUQueue {
    HashMap<Integer, Integer> map;
    public MRUQueue(int n) {
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, i);
    }

    public int fetch(int k) {
        int ans = map.get(k);
        for (int i = k; i < map.size(); i++)
            map.put(i, map.get(i + 1));
        map.put(map.size(), ans);
        return ans;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
