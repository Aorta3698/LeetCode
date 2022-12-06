class Solution {
    int[] parent;
    int[] size;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        parent = IntStream.range(0, graph.length).toArray();
        size = new int[graph.length];
        Arrays.fill(size, 1);
        for (int i = 0; i < graph.length; i++){
            dfs(graph, i);
        }

        Arrays.sort(initial);
        int[] cnt = new int[graph.length];
        for (int v : initial){
            ++cnt[find(v)];
        }

        int ans = -1;
        for (int v : initial){
            if (ans == -1 || cnt[find(v)] == 1 && (cnt[find(ans)] > 1 || size[find(ans)] < size[find(v)])){
                ans = v;
            }
        }

        return ans;
    }

    private int find(int x){
        return x == parent[x]?
            x : (parent[x] = find(parent[x]));
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (size[x] > size[y]){
            parent[y] = x;
            size[x] += size[y];
        }else{
            parent[x] = y;
            size[y] += size[x];
        }
    }

    private void dfs(int[][] graph, int cur){
        if (find(cur) != cur || size[cur] > 1) return;

        for (int i = 0; i < graph.length; i++){
            if (i == cur) continue;
            if (graph[cur][i] != 0){
                union(cur, i);
                dfs(graph, i);
            }
        }
    }
}
