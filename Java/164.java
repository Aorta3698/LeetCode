class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length == 1)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int atLeast = (max-min)/(nums.length-1);
        int bucketRange = Math.max(atLeast, 1);
        Bucket[] buckets = new Bucket[(max-min)/bucketRange+1];
        Arrays.setAll(buckets, o -> new Bucket());
        for (int n : nums){
            int position = (n-min)/bucketRange;
            buckets[position].max = Math.max(n, buckets[position].max);
            buckets[position].min = Math.min(n, buckets[position].min);
            buckets[position].isEmpty = false;
        }

        int ans = 0;
        int prevMax = -1;
        for (Bucket bucket : buckets){
            if (bucket.isEmpty){
                continue;
            }
            if (prevMax!=-1){
                ans = Math.max(ans, bucket.min-prevMax);
            }
            prevMax=bucket.max;
        }

        return ans;
    }

    private class Bucket {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean isEmpty=true;
        Bucket(){}
    }
}
