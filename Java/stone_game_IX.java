class Solution {
    public boolean stoneGameIX(int[] stones) {
        if (stones.length == 1) return false;

        int[] count = new int[3];
        for (int i = 0; i < stones.length; i++) count[stones[i] % 3]++;

        //2, 2, 1, 1 -> win
        //2, 1, 1 -> win
        //2, 2, 2, 1 -> win
        //1, 1 -> lose
        //1, 1, 1 -> lose
        //2, 2 -> lose
        //2, 2, 2 -> lose
        if (count[2] == 0 || count[1] == 0) return count[0] % 2 == 1 && (count[1] > 2 || count[2] > 2);
        return count[0] % 2 == 0 || Math.abs(count[1] - count[2]) > 2;
    }
}
