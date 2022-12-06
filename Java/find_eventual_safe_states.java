class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdeg = new int[graph.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++){
            for (int v : graph[i]){
                map.putIfAbsent(v, new ArrayList<>());
                map.get(v).add(i);
            }
            outdeg[i] = graph[i].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < outdeg.length; i++)
            if (outdeg[i] == 0) queue.offer(i);

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans.add(cur);
            if (map.get(cur) == null) continue;
            for (int v : map.get(cur))
                if(--outdeg[v] == 0) queue.offer(v);
        }

        Collections.sort(ans);
        return ans;
    }
}
