https://leetcode.com/problems/distance-to-a-cycle-in-undirected-graph/discuss/2111416/Java-or-DFS-%2B-DFS-or-Explained!
class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        int[] ans = new int[n];
        Set<Integer> cycle = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        findCycle(0, -1, cycle, new boolean[n], map);
        for (int c : cycle){
            dfs(c, 0, ans, cycle, map);
        }
        return ans;
    }

    private int findCycle(int i, int p, Set<Integer> cycle, boolean[] seen, Map<Integer, List<Integer>> map){
        if (seen[i])
            return i;
        seen[i] = true;
        for (int next : map.get(i)){
            if (next != p){
                int n = findCycle(next, i, cycle, seen, map);
                if (n > -1){
                    cycle.add(i);
                }
                if (n != -1)
                    return n == i? -2 : n;
            }
        }
        return -1;
    }

    private void dfs(int i, int d, int[] ans, Set<Integer> cycle, Map<Integer, List<Integer>> map){
        ans[i] = d;
        for (int next : map.get(i)){
            if (ans[next] == 0 && !cycle.contains(next)){
                dfs(next, d+1, ans, cycle, map);
            }
        }
    }
}
