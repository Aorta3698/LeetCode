class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        long[] dp = new long[arr.length];
        int[] min = new int[arr.length];
        Arrays.fill(min, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                min[stack.poll()] = i;
            }
            stack.push(i);
        }
        for (int i = 0; i < arr.length; i++){
            dp[i] = arr[i] * (i - min[i]) + (min[i] == -1? 0 : dp[min[i]]);
            ans += dp[i];
        }
        return (int)(ans % (int)(1e9 + 7));
    }
}
