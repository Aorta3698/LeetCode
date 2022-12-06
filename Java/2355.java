https://leetcode.com/problems/maximum-number-of-books-you-can-take/discuss/2358714/Java-or-Stack-%2B-DP-or-With-Explanations-and-Comments-while-I-was-coding
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        long[] dp = new long[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            // From my observation by playing with the numbers, looks like we have to find:
            // books[j]+i-j<=books[i], find the closest previous j -> choke point
            // I think it looks like a monostack with dp, so let's try that i guess.
            while(!stack.isEmpty() && books[i] < books[stack.peek()]+i-stack.peek()){
                stack.pop();
            }
            int j = stack.isEmpty()? Math.max(0, i-books[i]+1) : stack.peek()+1;
            dp[i] = 1L*(books[i]+books[i]-(i-j))*(i-j+1)/2 + (stack.isEmpty()? 0 : dp[j-1]);
            stack.push(i);
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}
