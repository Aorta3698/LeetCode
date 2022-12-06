https://leetcode.com/problems/find-eventual-safe-states/discuss/2144895/Java-or-Simple-DFS-w-Memo
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Boolean[] memo = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (dfs(i, graph, memo)){
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int i, int[][] graph, Boolean[] memo){
        if (memo[i] != null)
            return memo[i];
        memo[i]=false;
        for (int next : graph[i]){
            if (!dfs(next, graph, memo))
                return false;
        }
        return memo[i]=true;
    }
}
