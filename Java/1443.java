https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/discuss/1805328/Java-Simple-DFS
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        return dfs(0, -1, map, hasApple) * 2;
    }

    private int dfs(int cur, int parent, Map<Integer, List<Integer>> map, List<Boolean> hasApple){
        int sum = 0;
        for (int next : map.getOrDefault(cur, Collections.emptyList())){
            if (next == parent) continue;
            sum += dfs(next, cur, map, hasApple);
        }
        return cur != 0 && (sum > 0 || hasApple.get(cur))? sum + 1 : sum;
    }
}
