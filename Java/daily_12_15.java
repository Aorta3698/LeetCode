class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indeg = new int[n];
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
            indeg[e[0]]++;
            indeg[e[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indeg[i] == 1)
                queue.add(i);

        while(n > 2){
            int size = queue.size();
            n -= size;
            while (size-- > 0)
                for (int v : map.get(queue.poll()))
                    if(--indeg[v] == 1)
                        queue.offer(v);
        }

        while(!queue.isEmpty()) ans.add(queue.poll());

        return ans;
    }
}
