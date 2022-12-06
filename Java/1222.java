https://leetcode.com/problems/queens-that-can-attack-the-king/discuss/1648282/Java-or-N-*-N-Infinite-Board-General-Solution-or-15-Lines
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] cand = new int[8];
        Arrays.fill(cand, -1);

        int i = 0;
        for (int[] q : queens){
            if (q[0] + q[1] == k[0] + k[1]) update(queens, q, k, cand, 0, i, 0);
            if (q[0] - q[1] == k[0] - k[1]) update(queens, q, k, cand, 2, i, 0);
            if (q[1] == k[1]) update(queens, q, k, cand, 4, i, 0);
            if (q[0] == k[0]) update(queens, q, k, cand, 6, i, 1);
            i++;
        }

        for (int idx : cand)
            if (idx != -1)
                ans.add(List.of(queens[idx][0], queens[idx][1]));

        return ans;
    }

    private static void update(int[][] queens, int[] q, int[] k, int[] cand, int id, int i, int j){
        if (q[j] < k[j]) ++id;
        if (cand[id] == -1 || Math.abs(q[j] - k[j]) < Math.abs(queens[cand[id]][j] - k[j]))
           cand[id] = i;
    }
}
