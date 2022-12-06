https://leetcode.com/problems/number-of-people-aware-of-a-secret/discuss/2229997/O(n)-or-2-Deques-or-Java
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int M = (int)1e9+7;
        int cur = 0;
        int ans = 1;
        Deque<int[]> forgotDeque = new ArrayDeque<>();
        Deque<int[]> delayDeque = new ArrayDeque<>();
        forgotDeque.offerLast(new int[]{1, 1});
        delayDeque.offerLast(new int[]{1, 1});
        for (int i = 1; i <= n; i++){
            if(!delayDeque.isEmpty() && delayDeque.peekFirst()[0]+delay<=i){
                cur = (cur+ delayDeque.pollFirst()[1])%M;
            }
            if(!forgotDeque.isEmpty() && forgotDeque.peekFirst()[0]+forget<=i){
                int x = forgotDeque.pollFirst()[1];
                ans = (ans-x+M)%M;
                cur = (cur-x+M)%M;
            }
            if (cur>0){
                delayDeque.offerLast(new int[]{i, cur});
                forgotDeque.offerLast(new int[]{i, cur});
                ans = (ans + cur)%M;
            }
        }

        return ans;
    }
}
