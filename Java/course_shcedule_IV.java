class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        Map<Integer, HashSet<Integer>> preMap = new HashMap<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) map.computeIfAbsent(p[0], o -> new ArrayList<>()).add(p[1]);

        int[] indeg = new int[numCourses];
        for (List<Integer> p : map.values())
            for (int v : p)
                indeg[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++)
            if (indeg[i] == 0) queue.offer(i);

        while(!queue.isEmpty()){
            int course = queue.poll();

            if (!map.containsKey(course)) continue;
            for (int v : map.get(course)){
                preMap.computeIfAbsent(v, o -> new HashSet<>()).add(course);
                preMap.get(v).addAll(preMap.computeIfAbsent(course, o -> new HashSet<>()));
                if (--indeg[v] == 0)
                    queue.offer(v);
            }
       }

       for (int[] p : queries)
           ans.add(preMap.containsKey(p[1]) && preMap.get(p[1]).contains(p[0]));

    return ans;
    }
}

// The Below Gives TLE, 68 / 68 Test Cases Passed But Took Too Long.
//
// HashMap<Map.Entry<Integer, Integer>, Boolean> seen = new HashMap<>();
// private boolean dfs(int q, int r, HashMap<Integer, List<Integer>> map){
//     if (seen.containsKey(Map.entry(q, r))) return seen.get(Map.entry(q, r));
//     if (q == r) return true;
//     if (!map.containsKey(q)) return false;

//     for (int v : map.get(q))
//         if (dfs(v, r, map)){
//             seen.put(Map.entry(v, r), true);
//             return true;
//         }

//     seen.put(Map.entry(q, r), false);
//     return false;
