class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer>[] heap = new PriorityQueue[2];
        Arrays.setAll(heap, o -> new PriorityQueue<>());
        int ans = 0, n = num, m = 1;
        while(n > 0){
            heap[(n % 10) % 2].offer(n % 10);
            n /= 10;
        }

        while(num > 0){
            ans += heap[(num % 10) % 2].poll() * m;
            m *= 10;
            num /= 10;
        }

        return ans;
    }
}
