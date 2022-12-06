class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++){
            List<String> e = equations.get(i);
            map.computeIfAbsent(e.get(0), o -> new HashMap<>()).put(e.get(1), values[i]);
            map.computeIfAbsent(e.get(1), o -> new HashMap<>()).put(e.get(0), 1/values[i]);
        }
        for (int i = 0; i < queries.size(); i++){
            String source = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            ans[i] = dfs(source, target, map, new HashSet<>());
        }
        return ans;
    }

    private double dfs(String cur, String target, Map<String, Map<String, Double>> map, Set<String> seen){
        if (seen.contains(cur))
            return -1;
        if (cur.equals(target) && map.containsKey(cur))
            return 1;
        seen.add(cur);
        Map<String, Double> now = map.getOrDefault(cur, Map.of());
        for (String next : now.keySet()){
            double c = dfs(next, target, map, seen);
            if (c > 0)
                return c * now.get(next);
        }

        return -1;
    }
}
