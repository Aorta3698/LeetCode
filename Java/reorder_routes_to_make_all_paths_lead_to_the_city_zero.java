class Solution {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<List<Integer>> routes = new HashSet<>();
        for (int[] c : connections){
            map.computeIfAbsent(c[0], o -> new ArrayList<>()).add(c[1]);
            map.computeIfAbsent(c[1], o -> new ArrayList<>()).add(c[0]);
            routes.add(List.of(c[0], c[1]));
        }

        List<List<Integer>> paths = new ArrayList<>();
        dfs(0, paths, new boolean[n], map);

        int count = 0;
        for (List<Integer> p : paths)
            if (routes.contains(p))
                count++;

        return count;
    }

    private boolean dfs(int city, List<List<Integer>> paths, boolean[] seen,
            HashMap<Integer, List<Integer>> map){
        if (seen[city]) return false;
        seen[city] = true;

        for (int next : map.get(city)){
            List<Integer> path = new ArrayList<>();
            if (dfs(next, paths, seen, map)){
                path.add(city);
                path.add(next);
                paths.add(path);
            }
        }

        return true;
    }
}
