/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
https://leetcode.com/problems/boundary-of-binary-tree/discuss/1790203/Java-or-Vague-Question-Description.
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // Queue<Item> queue = new ArrayDeque<>(List.of(new Item(root, 0)));
        // while(!queue.isEmpty()){
        //     int sz = queue.size();
        //     int n = sz;
        //     while(--sz >= 0){
        //         Item cur = queue.poll();
        //         TreeNode node = cur.node;
        //         if (node.left  != null){
        //             queue.offer(new Item(node.left, -1));
        //         }
        //         if (node.right != null){
        //             queue.offer(new Item(node.right, 1));
        //         }
        //         if (node.left == node.right) continue;
        //         if (n == 1 && cur.from == 1){
        //             stack.push(node.val);
        //         }
        //         else if (n - sz == 1){
        //             ans.add(node.val);
        //         }
        //         else if (sz == 0){
        //             stack.push(node.val);
        //         }
        //     }
        // }
        // dfs(root, ans);
        // for (int n : stack){
        //     ans.add(n);
        // }
        // return ans;
        ans.add(root.val);
        dfs(root.left , ans, -1);
        dfs(root.right, ans,  1);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans, int part){
        if (root == null) return;
        if (root.right == root.left){
            ans.add(root.val);
            return;
        }
        int r = 0, l = 0;
        if (part == -1){
            l = root.left == null? 0 : -1;
            r = -1 - l;
            ans.add(root.val);
        }
        if (part == 1){
            r = root.right == null? 0 : 1;
            l = 1 - r;
        }
        dfs(root.left , ans, l);
        dfs(root.right, ans, r);
        if (part == 1) {
            ans.add(root.val);
        }
    }

    // private class Item{
    //     TreeNode node;
    //     int from;
    //     Item(TreeNode node, int from){
    //         this.node = node;
    //         this.from = from;
    //     }
    // }

    // private void dfs(TreeNode root, List<Integer> leaf){
    //     if (root == null) return;
    //     if (root.right == root.left){
    //         leaf.add(root.val);
    //     }
    //     dfs(root.left , leaf);
    //     dfs(root.right, leaf);
    // }
}
