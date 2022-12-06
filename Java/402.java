https://leetcode.com/problems/remove-k-digits/discuss/1780009/java-monostack-no-leading-zero
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > ch){
                stack.poll();
                k--;
            }
            if (ch != '0' || !stack.isEmpty()){
                stack.push(ch);
            }
        }
        while(--k >= 0 && !stack.isEmpty()){
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);

        return sb.isEmpty()? "0" : sb.reverse().toString();
    }
}
