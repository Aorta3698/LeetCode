class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            int[] cur = new int[]{ch, 1};
            if (!stack.isEmpty() && stack.peek()[0] == cur[0]){
                cur[1] += stack.pop()[1];
            }
            if (cur[1] < k){
                stack.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((""+(char)(stack.peekLast()[0])).repeat(stack.pollLast()[1]));
        }
        return sb.toString();
    }
}
