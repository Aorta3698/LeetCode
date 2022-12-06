https://leetcode.com/problems/validate-stack-sequences/discuss/1853082/Java-or-98-Speed-or-Simulate-it
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int end = 0;
        for (int i = 0; i < pushed.length; i++){
            deque.push(pushed[i]);
            while(!deque.isEmpty() && deque.peek() == popped[end]){
                deque.pop();
                end++;
            }
        }
        return end == popped.length;
    }
}
