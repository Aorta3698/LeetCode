class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest/minutesToDie+1;
        int ans = 0;
        int cur = 1;
        while(cur<buckets){
            ans++;
            cur*=n;
        }
        return ans;
    }
}
