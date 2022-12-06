https://leetcode.com/problems/detonate-the-maximum-bombs/discuss/1625095/Java-or-Directed-Graph-or-DFS-or-95-Speed-or-Explanations

class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bombs.length; i++){
            for (int j = i + 1; j < bombs.length; j++){
                double d = dist(bombs[i], bombs[j]);
                if (Double.compare(bombs[i][2], d) >= 0) map.computeIfAbsent(i, o -> new ArrayList<>()).add(j);
                if (Double.compare(bombs[j][2], d) >= 0) map.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
            }
        }

        int ans = 0;
        boolean[] seen = new boolean[bombs.length];
        for (int i = 0; i < bombs.length; i++)
            if (!seen[i])
                ans = Math.max(dfs(i, map, new boolean[bombs.length], seen), ans);

        return ans;
    }

    private int dfs(int idx, HashMap<Integer, List<Integer>> map, boolean[] taken, boolean[] seen){
        taken[idx] = seen[idx] = true;

        int count = 1;
        for (int b : map.getOrDefault(idx, Collections.emptyList()))
            if (!taken[b])
                count += dfs(b, map, taken, seen);

        return count;
    }

    private static double dist(int[] a, int[] b){
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
