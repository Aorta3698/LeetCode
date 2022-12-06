class Solution {
    public String simplifyPath(String path) {
        String[] each = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String e : each){
            if (e.isEmpty() || e.equals(".")) continue;
            else if (e.equals("..")){
                stack.pollFirst();
            }else{
                stack.push(e);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
            if (!stack.isEmpty()){
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
