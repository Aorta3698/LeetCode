class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : nums){
            int cur = n;
            while(!stack.isEmpty() && gcd(cur, stack.peek()) > 1){
                cur = lcm(stack.pop(), cur);
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()){
            ans.add(stack.pollLast());
        }
        return ans;
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }

    private int lcm(int a, int b){
        return (int)(1L*a*b/gcd(a,b));
    }
}
