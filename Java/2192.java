class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] path = new ArrayList[n];
        Arrays.setAll(path, o -> new ArrayList<>());
        Map<Integer, Set<Integer>> map  = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] e : edges){
            path[e[1]].add(e[0]);
            indegree[e[0]]++;
        }

        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                dfs(i, path, map);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            List<Integer> tmp = new ArrayList<>(map.get(i));
            Collections.sort(tmp);
            ans.add(tmp);
        }

        return ans;
    }

    private Set<Integer> dfs(int cur, List<Integer>[] path, Map<Integer, Set<Integer>> map){
        if (map.containsKey(cur)) return map.get(cur);
        Set<Integer> tmp = new HashSet<>();
        for (int next : path[cur]){
            tmp.addAll(dfs(next, path, map));
            tmp.add(next);
        }
        map.put(cur, new HashSet<>(tmp));
        return tmp;
    }
}
