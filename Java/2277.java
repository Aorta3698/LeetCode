https://leetcode.com/problems/closest-node-to-path-in-tree/discuss/2115464/Java-or-O(MN)-or-DFS-%2B-DFS
class Solution {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        int[] ans = new int[query.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        for (int i = 0; i < query.length; i++){
            int[] q = query[i];
            Set<Integer> path = new HashSet<>();
            findPath(q[0], -1, q[1], path, map);
            for (int node : path){
                if (dfs(node, -1, q[2], path, map)){
                    ans[i] = node;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean findPath(int st, int parent, int end, Set<Integer> path, Map<Integer, List<Integer>> map){
        if (st == end){
            path.add(st);
            return true;
        }
        for (int next : map.get(st)){
            if (next != parent && findPath(next, st, end, path, map)){
                path.add(st);
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int cur, int parent, int target, Set<Integer> path, Map<Integer, List<Integer>> map){
        if (cur == target)
            return true;
        for (int next : map.get(cur)){
            if (parent != next && !path.contains(next) && dfs(next, cur, target, path, map))
                return true;
        }
        return false;
    }
}
