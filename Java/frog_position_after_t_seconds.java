class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (target == 1) return edges.length == 0? 1 : 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }

        LinkedList<Integer> path = new LinkedList<>();
        findPath(map, path, 1, target, new boolean[n+1]);
        System.out.println(path);
        if (path.size() != t && map.get(target).size() != 1 || path.size() > t) return 0;

        double ans = 1;
        for (int i = 0; i < path.size(); i++){
            int numOfPath = map.get(path.get(i)).size() - 1;
            if (i == 0) numOfPath++;
            ans /= numOfPath;
        }

        return ans;
    }

    private boolean findPath(HashMap<Integer, List<Integer>> map, LinkedList<Integer> path,
            int start, int target, boolean[] visited){

        if (start == target) return true;
        if (map.get(start) == null || visited[start]) return false;

        visited[start] = true;
        for (int v : map.get(start))
            if (findPath(map, path, v, target, visited)){
                path.addFirst(start);
                return true;
            }

        return false;
    }
}
