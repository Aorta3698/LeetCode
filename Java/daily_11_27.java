class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        getPath(graph, 0, graph.length - 1, new LinkedList<>(List.of(0)), ans);
        return ans;
    }

    private void getPath(int[][] graph, int start, int target,
            LinkedList<Integer> path, List<List<Integer>> ans){
        if (start == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[start].length; i++){
            path.add(graph[start][i]);
            getPath(graph, graph[start][i], target, path, ans);
            path.removeLast();
        }
    }
}
