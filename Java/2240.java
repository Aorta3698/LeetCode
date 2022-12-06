class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        while(total >= 0){
            ans += 1 + total / cost2;
            total -= cost1;
        }
        return ans;
    }
}
