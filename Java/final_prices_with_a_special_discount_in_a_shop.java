class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                int idx = stack.pop();
                prices[idx] -= prices[i];
            }

            stack.push(i);
        }

        return prices;
    }
}
