https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/1809470/Java-or-2-Simple-Solutions-or-98-Speed.
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int lo = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : preorder){
            while(!stack.isEmpty() && stack.peek() < n){
                lo = stack.pop();
            }
            if (lo > n){
                return false;
            }
            stack.push(n);
        }
        return true;
        // return dfs(0, preorder, 0, 10001) == preorder.length;
    }

    // SIMULATION
    // This solution is faster
    //
    // private int dfs(int idx, int[] pre, int lo, int hi){
    //     if (idx == pre.length || pre[idx] < lo || pre[idx] > hi){
    //         return idx;
    //     }
    //     int val = pre[idx++];
    //     idx = dfs(idx, pre, lo, val);
    //     idx = dfs(idx, pre, val, hi);
    //     return idx;
    // }
}
