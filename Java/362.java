class HitCounter {

    private Map<Integer, Integer> map;
    public HitCounter() {
        map = new HashMap<>();
    }

    public void hit(int timestamp) {
        map.merge(timestamp, 1, Integer::sum);
    }

    public int getHits(int timestamp) {
        int sum = 0;
        for (int i = Math.max(0, timestamp - 299); i <= timestamp; i++)
            if (map.containsKey(i))
                sum += map.get(i);
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
