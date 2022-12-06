https://leetcode.com/problems/baseball-game/discuss/1636653/Java-ArrayDeque-%2B-Enhanced-Switch-%2B-Why-deque-over-stack
class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String o : ops){
            switch(o){
                case "C" -> stack.pop();
                case "D" -> stack.push(stack.peek() * 2);
                case "+" -> {
                        int prev = stack.pop();
                        int pp = stack.peek();
                        stack.push(prev);
                        stack.push(prev + pp);
                }
                default -> stack.push(Integer.parseInt(o));
            };
        }

        int ans = 0;
        for (int n : stack) ans+= n;

        return ans;
    }
}
