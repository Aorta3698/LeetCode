class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int mask = (1 << i);
            ans += ((start & mask) ^ (goal & mask)) > 0? 1 : 0;
        }
        return ans;
    }
}
