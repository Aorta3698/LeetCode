class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if (ch == 'c' && stack.size() >= 2){
                char prev = stack.poll();
                if (prev == 'b' && stack.peek() == 'a'){
                    stack.poll();
                    continue;
                }else{
                    stack.push(prev);
                }
            }
            stack.push(ch);
        }

        return stack.isEmpty();
    }
}
