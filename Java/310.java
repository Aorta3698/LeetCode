class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        int[] ind = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o->new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o->new ArrayList<>()).add(e[0]);
            ind[e[0]]++;
            ind[e[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (ind[i]==1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            ans.clear();
            for (int sz = queue.size(); sz > 0; sz--){
                int cur = queue.poll();
                ans.add(cur);
                for (int next : map.get(cur)){
                    if (--ind[next]==1){
                        queue.offer(next);
                    }
                }
            }
        }
        return n==1?List.of(0):ans;
    }
}
