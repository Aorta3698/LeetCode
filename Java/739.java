class Solution {
    public int[] dailyTemperatures(int[] A) {
        int[] ans = new int[A.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++){
            while(!stack.isEmpty() && A[i] > A[stack.peek()]){
                ans[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
