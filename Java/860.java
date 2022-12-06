class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[2];
        for (int b : bills){
            if (b == 20){
                if (cnt[1] > 0){
                    cnt[1]--;
                    cnt[0]--;
                }else
                    cnt[0]-=3;
            }
            if (b == 10) {cnt[0]--; cnt[1]++;}
            if (b == 5) cnt[0]++;

            if (cnt[0] < 0 || cnt[1] < 0) return false;
        }

        return true;
    }
}
