class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = -10000, min = -max;
        for (int n : nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] count = new int[max - min + 1];
        for (int n : nums){
            count[n - min]++;
        }

        max = 0;
        for (int n : count){
            max = Math.max(n, max);
        }

        List<Integer>[] bucket = new ArrayList[max + 1];
        Arrays.setAll(bucket, o -> new ArrayList<>());
        for (int i = 0; i < count.length; i++){
            bucket[count[i]].add(i + min);
        }

        int[] ans = new int[k];
        for (int i = max, j = 0; k > 0; i--){
            int t = Math.min(bucket[i].size(), k);
            k -= t;
            while(t-- > 0){
                ans[j++] = bucket[i].get(t);
            }
        }

        return ans;
    }
}
