class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> leaf = new ArrayList<>();
        int[] indeg = new int[n];
        for (List<Integer> e : edges)
            indeg[e.get(1)]++;

        for (int i = 0; i < n; i++)
            if (indeg[i] == 0)
                leaf.add(i);

        return leaf;
    }
}
