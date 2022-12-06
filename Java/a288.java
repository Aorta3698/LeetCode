class Solution {
    public int largestInteger(int num) {
        int ans = 0, n = num;
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();
        while(n > 0){
            int m = n % 10;
            if (m % 2 == 0)
                even.offer(m);
            else
                odd.offer(m);
            n /= 10;
        }

        int j = 1;
        while(num > 0){
            int m = num % 10;
            int k = 0;
            if (m % 2 == 0)
                k = even.poll();
            else
                k = odd.poll();
            ans += j * k;
            j *= 10;
            num /= 10;
        }

        return ans;
    }
}
