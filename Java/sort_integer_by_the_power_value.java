class Solution {
    public int getKth(int lo, int hi, int k) {
        int[] result = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) result[i-lo] = compute(i);

        Comparator<Integer> comp = (a, b) -> result[b - lo] - result[a - lo];
        comp = comp.thenComparing((a, b) -> b - a);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(comp);

        for (int i = lo; i <= hi; i++) {
            maxheap.offer(i);
            if (maxheap.size() > k) maxheap.poll();
        }

        return maxheap.poll();
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    private int compute(int n){
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int count = n % 2 == 0? compute(n / 2) : compute(3 * n + 1);
        map.put(n, ++count);
        return count;
    }
}
