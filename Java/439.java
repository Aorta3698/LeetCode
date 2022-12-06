https://leetcode.com/problems/ternary-expression-parser/discuss/1952242/Java-or-Going-Backwards
class Solution {
    public String parseTernary(String A) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = A.length() - 1; i >=0; i--){
            String cur = A.substring(i, Math.min(i + 2, A.length()));
            if (cur.equals("T?")){
                int tmp = stack.pop();
                stack.pop();
                stack.push(tmp);
            }else if (cur.equals("F?")){
                stack.pop();
            }else if (A.charAt(i) != ':' && A.charAt(i) != '?'){
                stack.push(i);
            }
        }
        return ""+A.charAt(stack.peek());
    }
}
