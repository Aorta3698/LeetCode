https://leetcode.com/problems/minimize-malware-spread-ii/discuss/1775047/Java-Simple-DFS-in-25-lines
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int max = -1, ans = 0;
        boolean[] virus = new boolean[graph.length];
        Arrays.sort(initial);
        for (int v : initial) virus[v] = true;
        for (int v : initial){
            int res = dfs(graph, v, v, new boolean[graph.length], virus);
            if (res > max){
                max = res;
                ans = v;
            }
        }

        return ans;
    }

    int dfs(int[][] graph, int st, int cur, boolean[] seen, boolean[] virus){
        if (seen[cur]) return 0;
        if (virus[cur] && st != cur) return -1000;
        seen[cur] = true;

        int sz = 0, tmp = 0;
        for (int i = 0; i < graph.length; i++){
            if (graph[cur][i] == 1){
                tmp = dfs(graph, st, i, seen, virus);
                sz = (st == cur? sz + Math.max(tmp, 0) : sz + tmp);
            }
        }

        return sz + 1;
    }
}
