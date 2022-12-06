class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int M = (int)1e9+7;
        long cur = 0;
        long ans = 1;
        Deque<long[]> forgotDeque = new ArrayDeque<>();
        Deque<long[]> delayDeque = new ArrayDeque<>();
        forgotDeque.offerLast(new long[]{1, 1});
        delayDeque.offerLast(new long[]{1, 1});
        for (int i = 1; i <= n; i++){
            while(!delayDeque.isEmpty() && delayDeque.peekFirst()[0]+delay<=i){
                cur = (cur+ delayDeque.pollFirst()[1])%M;
            }
            while(!forgotDeque.isEmpty() && forgotDeque.peekFirst()[0]+forget<=i){
                long x = forgotDeque.pollFirst()[1];
                ans = (ans-x+M)%M;
                cur = (cur-x+M)%M;
            }
            if (cur>0){
                delayDeque.offerLast(new long[]{i, cur});
                forgotDeque.offerLast(new long[]{i, cur});
                ans = (ans + cur)%M;
            }
        }

        return (int)(ans % M);
    }
}
