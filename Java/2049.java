class Solution {
    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++){
            map.computeIfAbsent(parents[i], o -> new ArrayList<>()).add(i);
        }
        return (int)dfs(0, map, parents.length)[2];
    }

    private long[] dfs(int cur, Map<Integer, List<Integer>> map, int n){
        long[][] next= new long[2][3];
        int i = 0;

        for (int child : map.getOrDefault(cur, Collections.emptyList())){
            next[i++] = dfs(child, map, n);
        }

        long r = next[0][0];
        long l = next[1][0];
        long score = Math.max(1, n - 1 - r - l) * Math.max(r, 1) * Math.max(l, 1);
        long[] cand= next[0][1] > next[1][1]? next[0] : next[1];
        cand[0] = r + l + 1;

        if (next[0][1] == next[1][1]){
            cand[2] += next[0][2];
        }

        if (score > cand[1]){
            cand[1] = score;
            cand[2] = 0;
        }
        if (score == cand[1]){
            cand[2]++;
        }

        return cand;
    }
}
