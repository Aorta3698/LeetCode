class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int[] exist = new int[2001];
        for (int i = 0; i < fronts.length; i++){
            if (fronts[i] == backs[i]){
                exist[fronts[i]] = -1;
            }
            if (exist[fronts[i]] != -1){
                exist[fronts[i]] = 1;
            }
            if (exist[backs[i]] != -1){
                exist[backs[i]] = 1;
            }
        }

        for (int i = 0; i <= 2000; i++){
            if (exist[i] <= 0) continue;
            return i;
        }
        return 0;
    }
}
