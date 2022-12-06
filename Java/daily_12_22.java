class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] ind = new int[numCourses], ans = new int[numCourses];
        for (int[] p : prerequisites){
            map.computeIfAbsent(p[1], o -> new ArrayList<>()).add(p[0]);
            ind[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++)
            if (ind[i] == 0)
                queue.offer(i);

        int idx = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[idx++] = cur;
            for (int next : map.getOrDefault(cur, Collections.emptyList()))
                if (--ind[next] == 0)
                    queue.offer(next);
        }

        return idx == numCourses? ans : new int[]{};
    }
}
