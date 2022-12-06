class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == stack.peek()) stack.poll();
            else stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
