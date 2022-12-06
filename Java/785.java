class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (state[i] == 0 && !dfs(i, graph, 1, state))
                return false;
        }
        return true;
    }

    private boolean dfs(int i, int[][] graph, int color, int[] state){
        if (state[i] != 0)
            return state[i] == color;
        state[i] = color;
        for (int next : graph[i]){
            if (!dfs(next, graph, -color, state))
                return false;
        }
        return true;
    }
}
