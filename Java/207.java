class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int[] p : prerequisites){
            map.computeIfAbsent(p[1], o->new ArrayList<>()).add(p[0]);
            ind[p[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < ind.length; i++){
            if (ind[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            numCourses--;
            for (int next : map.getOrDefault(queue.poll(), List.of())){
                if (--ind[next]==0){
                    queue.offer(next);
                }
            }
        }
        return numCourses==0;
    }
}
