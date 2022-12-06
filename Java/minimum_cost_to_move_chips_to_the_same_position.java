class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        for (int p : position)
            if (p % 2 == 1) odd++;

        return Math.min(odd, position.length - odd);
    }
}
