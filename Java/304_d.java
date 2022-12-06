class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indg = new int[n];
        for (int i = 0; i < n; i++){
            if (edges[i] != -1){
                indg[edges[i]]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indg[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (edges[cur] != -1 && --indg[edges[cur]] == 0){
                queue.offer(edges[cur]);
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++){
            if (indg[i] > 0){
                ans = Math.max(ans, dfs(i, indg, edges));
            }
        }
        return ans;
    }

    private int dfs(int idx, int[] indg, int[] map){
        if (indg[idx] == -1){
            return 0;
        }
        indg[idx]=-1;
        return 1 + dfs(map[idx], indg, map);
    }
}
