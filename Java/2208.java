class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0, loss = 0;
        for (int n : nums){
            maxheap.offer(Double.valueOf(n));
            sum += n;
        }

        int ans = 0;
        while(2 * loss < sum){
            double cur = maxheap.poll();
            loss += cur / 2;
            maxheap.offer(cur / 2);
            ans++;
        }

        return ans;
    }
}
