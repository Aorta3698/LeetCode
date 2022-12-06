class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // int[] indeg = new int[n];
        // HashMap<Integer, List<Integer>> map = new HashMap<>();
        // for (int[] r : relations){
        //     int x = r[0] - 1;
        //     int y = r[1] - 1;
        //     map.computeIfAbsent(x, o -> new ArrayList<>()).add(y);
        //     indeg[y]++;
        // }

        // int[] pathLen = new int[n];
        // Comparator<Integer> comp = (a, b) -> pathLen[b] - pathLen[a];
        // comp = comp.thenComparing((a, b) -> {
        //     int numA = numOfOpenIfChosen(map, a, indeg);
        //     int numB = numOfOpenIfChosen(map, b, indeg);
        //     return numB - numA;
        // });
        // comp = comp.thenComparing((a, b) -> {
        //     if (!map.containsKey(b)) return -1;
        //     else if (!map.containsKey(a)) return 1;
        //     else return map.get(b).size() - map.get(a).size();
        // });

        // PriorityQueue<Integer> maxheap = new PriorityQueue<>(comp);
        // List<Integer> leaves = new ArrayList<>();
        // for (int i = 0; i < n; i++)
        //     if (indeg[i] == 0)
        //         leaves.add(i);

        // for (int leaf : leaves) dfs(leaf, pathLen, map);
        // System.out.println(Arrays.toString(pathLen));

        // for (int i = 0; i < n; i++)
        //     if (indeg[i] == 0)
        //         maxheap.offer(i);

        // int ans = 0;
        // while(!maxheap.isEmpty()){
        //     int size = Math.min(k, maxheap.size());
        //     List<Integer> nextCourses = new ArrayList<>();
        //     while(size-- > 0){
        //         int cur = maxheap.poll();
        //         if (map.containsKey(cur)){
        //             for (int next : map.get(cur))
        //                 if (--indeg[next] == 0)
        //                     nextCourses.add(next);
        //         }
        //     }
        //     for (int c : nextCourses) maxheap.add(c);
        //     ans++;
        // }

        // return ans;
    // }

    // private int dfs(int cur, int[] path, HashMap<Integer, List<Integer>> map){
        // if (!map.containsKey(cur)) return 0;
        // if (path[cur] != 0) return path[cur];

        // int max = 0;
        // for (int next : map.get(cur))
        //     max = Math.max(dfs(next, path, map), max);

        // path[cur] = 1 + max;
        // return path[cur];
    // }

    // private int numOfOpenIfChosen(HashMap<Integer, List<Integer>> map, int cur, int[] indeg){
        // if (!map.containsKey(cur)) return 0;
        // int num = 0;
        // for (int next : map.get(cur))
        //     if (indeg[next] == 1)
        //         num++;
        // return num;
    // }
}
