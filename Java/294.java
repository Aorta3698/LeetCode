https://leetcode.com/problems/flip-game-ii/discuss/2489299/Java-or-Optimized-BItMask-DP-or-Explained
class Solution {
    Map<Long, Boolean> map = new HashMap<>();
    public boolean canWin(String A) {
        long hash = 0;
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) == '+'){
                hash |= 1L<<i;
            }
        }
        return solve(hash);
    }

    private boolean solve(long a){
        if (map.containsKey(a)){
            return map.get(a);
        }
        if ((a & a>>1) == 0){
            map.put(a, false);
            return false;
        }
        for (long k = 3; a >= k; k <<= 1){
            if ((a & k) == k && !solve(a^k)){
                map.put(a, true);
                return true;
            }
        }
        map.put(a, false);
        return false;
    }
}
