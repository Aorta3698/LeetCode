class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : adjacentPairs){
            map.computeIfAbsent(a[0], o -> new ArrayList<>()).add(a[1]);
            map.computeIfAbsent(a[1], o -> new ArrayList<>()).add(a[0]);
        }

        int start = -1;
        for (int key : map.keySet())
            if (map.get(key).size() == 1)
                start = key;

        int[] ans = new int[map.size()];
        dfs(start, map, new HashSet<>(), ans, 0);

        return ans;
    }

    private void dfs(int start, Map<Integer, List<Integer>> map, Set<Integer> seen, int[] ans, int idx){
        if (seen.contains(start)) return;

        seen.add(start);
        ans[idx] = start;
        for (int next : map.get(start))
            dfs(next, map, seen, ans, idx + 1);
    }
}
