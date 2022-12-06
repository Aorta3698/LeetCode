class Solution {
    public int maximumXOR(int[] nums) {
        boolean[] bits = new boolean[32];
        for (int n : nums){
            for (int i = 0; n > 0; i++, n>>=1){
                if ((n&1)>0){
                    bits[i]=true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++){
            if (bits[i]){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
