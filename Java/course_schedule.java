class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites){
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }
        int[] ans = new int[numCourses];
        int[] in = new int[numCourses];
        for (List<Integer> u : map.values())
            for (int v : u)
                in[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (in[i] == 0) queue.offer(i);

        int visited = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans[visited++] = u;

            if (map.get(u) == null) continue;
            for (int v : map.get(u)){
                if(--in[v] == 0) queue.offer(v);
            }
        }

        return visited == numCourses;
    }
}
