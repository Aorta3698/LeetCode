class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode n : nodes)
            set.add(n.val);

        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, HashSet<Integer> set){
        if (root == null) return null;
        if (set.contains(root.val)) return root;

        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right, set);

        if (l != null && r != null) return root;
        else return l == null? r : l;
    }
}

// IF NODE MAY NOT APPEAR IN THE TREE
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> need = new HashSet<>();
        for (TreeNode n : nodes){
            need.add(n);
        }

        int[] count = new int[1];
        return dfs(root, need, count);
    }

    private TreeNode dfs(TreeNode root, Set<TreeNode> need, int[] count){
        if (root == null){
            return null;
        }

        int now = count[0];
        TreeNode right = dfs(root.right, need, count);
        int rc = count[0] - now;
        TreeNode left  = dfs(root.left, need, count);
        int lc = count[0] - rc - now;

        if (need.contains(root)){
            count[0]++;
            if (1 + rc + lc == need.size()){
                return root;
            }
        }
        if (lc == need.size()){
            return left;
        }
        if (rc == need.size()){
            return right;
        }
        if (rc + lc == need.size()){
            return root;
        }
        return null;
    }
}
