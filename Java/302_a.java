class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int n : nums){
            count[n]++;
        }
        int[] ans = new int[2];
        for (int i = 0; i <= 100; i++){
            ans[0]+=count[i]/2;
            ans[1]+=count[i]%2;
        }
        return ans;
    }
}
