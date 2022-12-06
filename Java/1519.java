class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        int[] ans = new int[n];
        dfs(0, -1, map, labels, ans);
        return ans;
    }

    private int[] dfs(int cur, int parent, Map<Integer, List<Integer>> map, String labels, int[] ans){
        int[] cnt = new int[26];
        for (int child : map.getOrDefault(cur, Collections.emptyList())){
            if (child == parent) continue;
            int[] next = dfs(child, cur, map, labels, ans);
            for (int i = 0; i < 26; i++){
                cnt[i] += next[i];
            }
        }
        ans[cur] = ++cnt[labels.charAt(cur) - 'a'];
        return cnt;
    }
}
