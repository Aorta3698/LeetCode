class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] d : dislikes){
            map.computeIfAbsent(d[0], o -> new HashSet<>()).add(d[1]);
            map.computeIfAbsent(d[1], o -> new HashSet<>()).add(d[0]);
        }

        int[] groups = new int[n+1];
        for (int i = 1; i <= n; i++){
            if (groups[i] == 0 && !dfs(map, 1, groups, i))
                return false;
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, HashSet<Integer>> map, int group, int[] groups, int idx){
        if (groups[idx] == -group) return false;
        if (groups[idx] == group) return true;
        groups[idx] = group;
        if (map.get(idx) == null) return true;
        for (int dislike : map.get(idx))
            if (!dfs(map, -group, groups, dislike)) return false;
        return true;
    }
}
