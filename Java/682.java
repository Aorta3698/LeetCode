class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String o : ops){
            switch(o){
                case "C" -> stack.pop();
                case "D" -> stack.push(stack.peek() * 2);
                case "+" -> {
                        int x = stack.pop();
                        int n = stack.peek() + x;
                        stack.push(x);
                        stack.push(n);
                }
                default -> stack.push(Integer.parseInt(o));
            };
        }

        int ans = 0;
        for (int n : stack){
            ans += n;
        }

        return ans;
    }
}
