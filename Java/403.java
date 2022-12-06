https://leetcode.com/problems/frog-jump/discuss/2113548/First-Jump-1-or-Java-Top-Down-DP
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++){
            map.put(stones[i], i);
        }
        return stones[1] == 1 && solve(1, 1, stones, map, new boolean[stones.length][stones.length]);
    }

    private boolean solve(int i, int k, int[] stones, Map<Integer, Integer> map, boolean[][] bad){
        if (i == stones.length-1)
            return true;
        if (i < 0 || k <= 0 || bad[k][i])
            return false;
        return  solve(map.getOrDefault(stones[i]+k-1, -1), k-1, stones, map, bad)
            ||  solve(map.getOrDefault(stones[i]+k,   -1), k,   stones, map, bad)
            ||  solve(map.getOrDefault(stones[i]+k+1, -1), k+1, stones, map, bad)
            ||  !(bad[k][i] = true);
    }
}
