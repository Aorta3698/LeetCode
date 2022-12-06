class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0, n = bits.length;
        while(idx < n){
            if (bits[idx] == 1){idx += 2; continue;}
            if (++idx == n) return true;
        }

        return false;
    }
}
