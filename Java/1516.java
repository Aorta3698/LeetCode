/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
https://leetcode.com/problems/move-sub-tree-of-n-ary-tree/discuss/2208578/4-cases-Java
class Solution {
    public Node moveSubTree(Node root, Node p, Node q) {
        if (q.children.contains(p)){ // do nothing
            return root;
        }
        Node pParent = findParent(root, p);
        Node qParent = findParent(root, q);
        if (p==root){ // edge case
            qParent.children.remove(q);
            q.children.add(root);
            return q;
        }
        if (isSubSet(p, q)){ // case one
            int idx = pParent.children.indexOf(p);
            pParent.children.set(idx, q);
            qParent.children.remove(q);
            q.children.add(p);
        }else{
            pParent.children.remove(p);
            q.children.add(p);
        }
        return root;
    }

    private boolean isSubSet(Node p, Node q){
        for (Node next : p.children){
            if (next == q || isSubSet(next, q)){
                return true;
            }
        }
        return false;
    }


    private Node findParent(Node cur, Node target){
        for (Node next : cur.children){
            if (next == target){
                return cur;
            }
            Node res = findParent(next, target);
            if (res != null){
                return res;
            }
        }

        return null;
    }
}
