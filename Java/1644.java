/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int[] count = new int[1];
        TreeNode ans = find(root, p, q, count);
        return count[0] == 2? ans : null;
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q, int[] count){
        if (root == null){
            return null;
        }

        TreeNode right = find(root.right, p, q, count);
        TreeNode left  = find(root.left , p, q, count);
        if (right != null && left != null){
            return root;
        }
        if (root == p || root == q){
            count[0]++;
            return root;
        }
        return right == null? left : right;
    }
}

// ANOTHER SOLUTION
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Item ret = find(root, p, q);
        if (ret == null){
            return null;
        }
        return ret.valid? ret.root : null;
    }

    private Item find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }

        Item right = find(root.right, p, q);
        Item left  = find(root.left , p, q);
        if (right != null && left != null){
            return new Item(root, true);
        }
        if (root == p || root == q){
            return new Item(root, right != left);
        }
        return right == null? left : right;
    }

    private class Item{
        TreeNode root;
        boolean valid = false;
        Item(TreeNode root, boolean valid){
            this.root = root;
            this.valid = valid;
        }
    }
}
