class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>(List.of('.'));
        for (char ch : s.toCharArray()){
            if (ch == ')' && deque.pop() != '(') return false;
            if (ch == ']' && deque.pop() != '[') return false;
            if (ch == '}' && deque.pop() != '{') return false;
            if (ch == '(' || ch == '[' || ch =='{') deque.push(ch);
        }
        return deque.peek() == '.';
    }
}
