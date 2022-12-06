class Solution {
    public int reductionOperations(int[] nums) {
        int[] bucket = new int[50001];
        int min = bucket.length, ans = 0;
        for (int n : nums){
            min = Math.min(n, min);
            bucket[n]++;
        }
        for (int i = min + 1, j = 0; i < bucket.length; i++){
            if (bucket[i] > 0){
                ans += bucket[i] * ++j;
            }
        }

        return ans;
    }
}
