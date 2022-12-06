class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, List<Integer>> routes = new HashMap<>();
        int target = -1;
        for (int[] neighbors : graph){
            ArrayList<Integer> n = new ArrayList<>();
            for (int neighbor : neighbors)
                n.add(neighbor);
            routes.put(++target, n);
        }
        List<List<Integer>> ans = new ArrayList<>();
        findPath(routes, 0, target, new LinkedList<>(), ans);

        return ans;
    }

    private void findPath(HashMap<Integer, List<Integer>> routes,
            int start, int end, LinkedList<Integer> path, List<List<Integer>> ans){

        path.add(start);
        if (start == end){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i : routes.get(start)){
            findPath(routes, i, end, path, ans);
            path.removeLast();
        }
    }
}
