class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            map.computeIfAbsent(edges[i][0], o -> new HashMap<>()).put(edges[i][1], succProb[i]);
            map.computeIfAbsent(edges[i][1], o -> new HashMap<>()).put(edges[i][0], succProb[i]);
        }
        double[] best = new double[n];
        Arrays.fill(best, -1);
        best[start] = 0;

        Comparator<Map.Entry<Double, Integer>> comp = Comparator.comparingDouble(o -> o.getKey());
        comp = comp.reversed();

        PriorityQueue<Map.Entry<Double, Integer>> maxHeap = new PriorityQueue<>(comp);
        maxHeap.add(Map.entry(1.0, start));

        boolean[] seen = new boolean[n];
        while(!maxHeap.isEmpty()){
            double prob = maxHeap.peek().getKey();
            int idx = maxHeap.poll().getValue();
            if (seen[idx] || !map.containsKey(idx)) continue;
            if (idx == end) break;
            seen[idx] = true;

            for (int v : map.get(idx).keySet()){
                if (seen[v]) continue;

                double w = map.get(idx).get(v);
                if (prob * w > best[v]){
                    best[v] = prob * w;
                    maxHeap.offer(Map.entry(best[v], v));
                }
            }
        }

        return best[end] == -1? 0 : best[end];
    }
}
