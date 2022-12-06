/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
https://leetcode.com/problems/change-the-root-of-a-binary-tree/discuss/1653819/Anyone-Else-Got-Their-Time-Wasted
class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        dfs(root, leaf, new HashMap<>());
        return leaf;
    }

    private static void dfs(Node root, Node target, Map<Node, Node> map){
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right!= null) map.put(root.right, root);
        if (root == target) {flip(map, root); return;}

        dfs(root.right, target, map);
        dfs(root.left , target, map);
    }

    private static void flip(Map<Node, Node> map, Node root){
        Node prev = null;
        while(map.get(root) != null){
            if (root.left != null && root.left != prev)
                root.right = root.left;
            root.left = map.get(root);
            root.parent = prev;
            prev = root;
            root = map.get(root);
        }

        if (root.left == prev) root.left = null;
        else root.right = null;
        root.parent = prev;
    }
}
