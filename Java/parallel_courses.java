class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDeg = new int[n+1];
        for (int[] r : relations){
            map.putIfAbsent(r[0], new ArrayList<>());
            map.get(r[0]).add(r[1]);
        }

        for (List<Integer> u : map.values())
            for (int v : u)
                inDeg[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (inDeg[i] == 0) queue.offer(i);

        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                n--;
                int course = queue.poll();
                if (map.get(course) == null) continue;
                for (int v : map.get(course))
                    if (--inDeg[v] == 0) queue.offer(v);
            }
        }

        return n == 0? ans : -1;
    }
}
