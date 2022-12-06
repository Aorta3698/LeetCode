class Solution {
    public int getXORSum(int[] A, int[] B) {
        int bit = 0;
        for (int n : B){
            bit ^= n;
            // for (int i = 0; i < 32; i++){
            //     if ((n & 1 << i) > 0){
            //         bit ^= 1 << i;
            //     }
            // }
        }
        int ans = 0;
        for (int n : A){
            for (int i = 0; i < 32; i++){
                if ((n & 1 << i) > 0 && (bit & 1 << i) > 0){
                    ans ^= 1<<i;
                }
            }
        }
        return ans;
    }
}
