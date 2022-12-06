class Solution {
    public boolean judgeSquareSum(int c) {
        int m = (int)Math.sqrt(c);
        if (m * m == c){
            return true;
        }

        int[] sq = new int[m + 1];
        // for (int i = 0; 1L*i*i <= c; i++){
        //     sq[i] = i * i;
        // }
        for (int i = 0; i <= m; i++){
            sq[i] = i*i;
            int lo = 0, hi = i;
            int g = (int)(c - 1L*i*i);
            while(lo <= hi){
                int mid = (lo + hi) >> 1;
                if (sq[mid] == g){
                    return true;
                }else if(sq[mid] < g){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
