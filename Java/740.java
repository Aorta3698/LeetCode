https://leetcode.com/problems/delete-and-earn/discuss/1820272/Java-or-Concise-5-Lines-or-Buckets-or-93
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        for (int n : nums){
            ++bucket[n];
        }

        for (int i = 2; i <= 10000; i++){
            bucket[i] = Math.max(bucket[i]*i + bucket[i - 2], bucket[i - 1]);
        }

        return bucket[10000];
    }
}
