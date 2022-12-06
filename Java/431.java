/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null){
            return null;
        }
        TreeNode ans = new TreeNode(root.val);
        if (root.children.isEmpty()){
            return ans;
        }
        ans.left = encode(root.children.get(0));
        TreeNode child = ans.left;
        for (int i = 1; i < root.children.size(); i++){
            child.right = encode(root.children.get(i));
            child = child.right;
        }
        return ans;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null){
            return null;
        }
        Node ans = new Node(root.val, new ArrayList<>());
        if (root.right==root.left){
            return ans;
        }
        TreeNode cur = root.left;
        while(cur != null){
            ans.children.add(decode(cur));
            cur=cur.right;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
