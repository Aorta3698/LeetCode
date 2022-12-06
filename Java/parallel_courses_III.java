class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[n + 1];
        for (int[] r : relations){
            map.computeIfAbsent(r[1] - 1, o -> new ArrayList<>()).add(r[0] - 1);
            indeg[r[0]]++;
        }

        List<Integer> top = new ArrayList<>();
        int[] best = new int[n + 1];
        // Arrays.fill(best, -1);

        for (int i = 1; i <= n; i++)
            if (indeg[i] == 0)
                top.add(i - 1);

        int max = 0;
        for (int c : top)
            max = Math.max(dfs(c, best, time, map), max);

        return max;
    }

    private int dfs(int start, int[] best, int[] time, HashMap<Integer, List<Integer>> map){
        if (!map.containsKey(start)) return time[start];
        if (best[start] != 0) return best[start];

        int ans = 0;
        for (int c : map.get(start))
            ans = Math.max(dfs(c, best, time, map), ans);

        best[start] = ans + time[start];
        return ans + time[start];
    }

    // private int dfs(int start, int[] best, int[] time, int tw, HashMap<Integer, List<Integer>> map){
    //     if (!map.containsKey(start)) return time[start] + tw;
    //     if (tw <= best[start]) return 0;

    //     best[start] = tw;
    //     int ans = 0;
    //     for (int c : map.get(start))
    //         ans = Math.max(dfs(c, best, time, tw + time[start], map), ans);

    //     return ans;
    // }
}
