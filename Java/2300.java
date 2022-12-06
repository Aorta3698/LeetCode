class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++){
            int lo = 0, hi = potions.length;
            while(lo < hi){
                int mid = (lo+hi)>>1;
                if (1L*potions[mid]*spells[i]>=success){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            ans[i] = potions.length - lo;
        }
        return ans;
    }
}
