class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int end = 0;
        for (String g : logs){
            String[] f = g.split(":");
            int id = Integer.parseInt(f[0]);
            String inst = f[1];
            int t = Integer.parseInt(f[2]);
            if (!stack.isEmpty()){
                ans[stack.peek()] += t - end + (inst.equals("end")? 1 : 0);
            }

            end = t;
            if (inst.equals("start")){
                stack.push(id);
            }else{
                stack.pop();
                end++;
            }
        }

        return ans;
    }
}
