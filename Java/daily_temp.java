class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                temperatures[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            temperatures[stack.pop()] = 0;

        return temperatures;
    }
}
