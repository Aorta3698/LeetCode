class Solution {
    public int smallestFactorization(int num) {
        if (num == 1)
            return 1;

        int[] factors = new int[10];
        for (int i = 2; i * i <= num; i++){
            if (i >= 10)
                return 0;
            while(num % i == 0){
                factors[i]++;
                num /= i;
            }
        }
        if (num >= 10)
            return 0;

        // 2, 2, 3 -> 34 or 26
        // 2, 2, 2, 2, 2, 3, 3 -> 489
        factors[num]++;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        takeMax(factors, 7, 1, 7, minheap);
        takeMax(factors, 5, 1, 5, minheap);
        takeMax(factors, 3, 2, 9, minheap);
        takeMax(factors, 2, 3, 8, minheap);
        if (factors[2] > 0 && factors[3] == 1){
            minheap.offer(6);
            factors[2]--;
            factors[3]--;
        }
        takeMax(factors, 2, 2, 4, minheap);
        takeMax(factors, 2, 1, 2, minheap);
        takeMax(factors, 3, 1, 3, minheap);

        long ans = 0;
        while(!minheap.isEmpty()){
            ans = (10 * ans + minheap.poll());
            if (ans > Integer.MAX_VALUE)
                return 0;
        }

        return (int)ans;
    }

    private void takeMax(int[] factors, int prime, int loss, int gain, PriorityQueue<Integer> minheap){
        while(factors[prime] >= loss){
            minheap.offer(gain);
            factors[prime] -= loss;
        }
    }
}
