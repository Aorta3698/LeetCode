class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());
        int sum = 0;
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                sum = 10 * sum + ch - '0';
            }else if (ch == '['){
                numStack.push(sum);
                stack.push(new StringBuilder());
                sum = 0;
            }else if (ch == ']'){
                String cur = stack.pop().toString().repeat(numStack.pop());
                stack.peek().append(cur);
            }else{
                stack.peek().append(ch);
            }
        }

        return stack.peek().toString();
    }
}
