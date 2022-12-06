class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] ans = new int[n];
        if (n == 1)
            return ans;
        int[] count = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        dfs(0, -1, 0, ans, count, map);
        solve(0, -1, ans[0], count, ans, map);
        return ans;
    }

    private int dfs(int idx, int parent, int dist, int[] ans, int[] count, Map<Integer, List<Integer>> map){
        ans[0] += dist++;
        for (int next : map.get(idx)){
            if (next != parent){
                count[idx]+=dfs(next, idx, dist, ans, count, map);
            }
        }
        return ++count[idx];
    }

    // private int getDist(int idx, int parent, int dist, Map<Integer, List<Integer>> map){
    //     int ans = dist++;
    //     for (int next : map.get(idx)){
    //         if (next != parent){
    //             ans += getDist(next, idx, dist, map);
    //         }
    //     }
    //     return ans;
    // }

    private void solve(int idx, int parent, int sum, int[] count, int[] ans, Map<Integer, List<Integer>> map){
        ans[idx] = sum;
        for (int next : map.get(idx)){
            if (next != parent){
                int nSum = sum + ans.length - count[next]*2;
                solve(next, idx, nSum, count, ans, map);
            }
        }
    }
}
