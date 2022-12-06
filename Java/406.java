// https://leetcode.com/problems/queue-reconstruction-by-height/discuss/1649392/java-backtracking-with-bitset-solution-ac

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> a[0]==b[0]? a[1]-b[1]:b[0]-a[0]);
        for (int[] p : people){
            maxheap.offer(p);
        }
        LinkedList<int[]> ans = new LinkedList<>();
        while(!maxheap.isEmpty()){
            int[] top = maxheap.poll();
            ans.add(top[1], top);
        }
        return ans.toArray(new int[0][]);
    }
}





// class Solution {
//     public int[][] reconstructQueue(int[][] people) {
//         int n = people.length, i = 0;
//         int[][] ans = new int[n][2];
//         Arrays.sort(people, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int[] p : people) map.putIfAbsent(p[0], i++);
//         backtrack(people, new boolean[n], 0, ans, new BitSet(), map);
//         return ans;
//     }

//     private boolean backtrack(int[][] p, boolean[] visited, int ptr, int[][] ans,
//             BitSet set, Map<Integer, Integer> map){
//         if (ptr == p.length)
//             return true;

//         for (int i = 0, hash = 0; i < p.length; i++){
//             if (visited[i]) continue;
//             if (set.get(map.get(p[i][0]), p.length).cardinality() == p[i][1]){
//                 visited[i] = true;
//                 ans[ptr] = p[i];
//                 hash = map.get(p[i][0]);
//                 while(set.get(hash)) hash++;
//                 set.set(hash);
//                 if (backtrack(p, visited, ptr + 1, ans, set, map)) return true;
//                 visited[i] = false;
//                 set.clear(hash);
//             }
//         }

//         return false;
//     }

    // private boolean backtrack(int[][] p, boolean[] visited, int ptr, int[][] ans, TreeSet<Integer> set){
    //     if (ptr == p.length)
    //         return true;

    //     for (int i = 0, hash = 0; i < p.length; i++){
    //         if (visited[i]) continue;
    //         if (set.headSet(p[i][0] * -2001 + 1).size() == p[i][1]){
    //             visited[i] = true;
    //             ans[ptr] = p[i];
    //             hash = p[i][0] * -2001 - p[i][1];
    //             set.add(hash);
    //             if (backtrack(p, visited, ptr + 1, ans, set)) return true;
    //             visited[i] = false;
    //             set.remove(hash);
    //         }
    //     }

    //     return false;
    // }
// }
