class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if (!stack.isEmpty() && Math.abs(ch - stack.peek()) == 'a' - 'A')
                stack.pop();
            else
                stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        return sb.reverse().toString();
    }
}
