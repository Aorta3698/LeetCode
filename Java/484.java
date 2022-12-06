https://leetcode.com/problems/find-permutation/discuss/1947427/Java-or-Stack-or-my-observations
class Solution {
    public int[] findPermutation(String s) {
        int hi = 0;
        int[] ans = new int[s.length() + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'I'){
                while(!stack.isEmpty()){
                    ans[stack.pop()] = ++hi;
                }
            }
            stack.push(i + 1);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = ++hi;
        }

        return ans;
    }
}
