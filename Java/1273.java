class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < nodes; i++){
            map.computeIfAbsent(parent[i], o -> new ArrayList<>()).add(i);
        }
        return dfs(map, 0, value)[0];
    }
    private int[] dfs(Map<Integer, List<Integer>> map, int idx, int[] value){
        int[] ans = new int[2];
        for (int child : map.getOrDefault(idx, Collections.emptyList())){
            int[] next = dfs(map, child, value);
            ans[0] += next[0];
            ans[1] += next[1];
        }
        ans[1] += value[idx];
        ans[0] = (ans[1] == 0? 0 : ++ans[0]);
        return ans;
    }
}
