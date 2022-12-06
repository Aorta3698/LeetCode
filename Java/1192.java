class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (List<Integer> c : connections){
            map[c.get(0)].add(c.get(1));
            map[c.get(1)].add(c.get(0));
        }
        int[] dp = new int[n];
        int[] lvl = new int[n];
        for (int i = 0; i < n; i++){
            dfs(i, -1, map, dp, lvl);
        }
        return ans;
    }

    private void dfs(int cur, int parent, List<Integer>[] map, int[] dp, int[] lvl){
        for (int next : map[cur]){
            if (lvl[next] == 0){
                lvl[next] = lvl[cur]+1;
                dfs(next, cur, map, dp, lvl);
                dp[cur] += dp[next];
            }else if (lvl[next] < lvl[cur]){
                dp[cur]++;
            }else if (lvl[next] > lvl[cur]){
                dp[cur]--;
            }
        }
        if (--dp[cur] == 0 && parent != -1){
            ans.add(List.of(cur, parent));
        }
    }
}

// class Solution {
//     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for (List<Integer> c : connections){
//             map.computeIfAbsent(c.get(0), o -> new ArrayList<>()).add(c.get(1));
//             map.computeIfAbsent(c.get(1), o -> new ArrayList<>()).add(c.get(0));
//         }

//         List<List<Integer>> ans = new ArrayList<>();
//         int[] order = new int[n], low = new int[n];
//         dfs(0, -1, 1, map, low, order, ans);

//         return ans;
//     }

//     private int dfs(int v, int p, int time, Map<Integer, List<Integer>> map,
//             int[] low, int[] order, List<List<Integer>> ans){
//         order[v] = low[v] = time;
//         for (int next : map.get(v)){
//             if (p == next) continue;
//             if (order[next] > 0) low[v] = Math.min(low[v], order[next]);
//             else{
//                 time = dfs(next, v, time + 1, map, low, order, ans);
//                 low[v] = Math.min(low[v], low[next]);
//                 if (low[next] > order[v]) ans.add(List.of(next, v));
//             }
//         }
//         return time;
//     }
// }
