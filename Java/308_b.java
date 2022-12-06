class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        for (int n : stack){
            sb.append(s.charAt(n));
        }
        return sb.reverse().toString();
    }
}
