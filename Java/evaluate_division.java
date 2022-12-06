class Solution {
    public double[] calcEquation(List<List<String>> equations,
            double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            List<String> e = equations.get(i);
            map.computeIfAbsent(e.get(0), o -> new HashMap<>()).put(e.get(1), values[i]);
            map.computeIfAbsent(e.get(1), o -> new HashMap<>()).put(e.get(0), 1/values[i]);
        }

        double[] ans = new double[queries.size()];
        int idx = 0;
        for (List<String> q : queries)
            ans[idx++] = find(map, q.get(0), q.get(1), new HashSet<>(), 1);

        return ans;
    }

    private double find(Map<String, HashMap<String, Double>> map,
            String start, String target, HashSet<String> seen, double w){
        if (!map.containsKey(start) || seen.contains(start)) return -1;
        if (start.equals(target)) return w;

        seen.add(start);
        double ans = 1;
        for (String next : map.get(start).keySet()){
            double result = find(map, next, target, seen, map.get(start).get(next));
            if (result != -1) return result*w;
        }

        return -1;
    }
}
