class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] groups = new int[graph.length];
        for(int i = 0; i < groups.length; i++)
            if (groups[i] == 0 && !assign(graph, i, 1, groups)) //two group 1, -1
                return false;

        return true;
    }

    private boolean assign(int[][] graph, int idx, int group, int[] groups){
        if (groups[idx] == -group) return false;
        if (groups[idx] == group) return true;

        groups[idx] = group;
        for (int other : graph[idx])
            if (!assign(graph, other, -group, groups))
                return false;

        return true;
    }
}
