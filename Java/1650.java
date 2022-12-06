/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// GOOD SOLUTION
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}

// SOLUTION TWO
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet<>();
        do{
            seen.add(p);
            p = p.parent;
        }while(p != null);

        while(!seen.contains(q)){
            q = q.parent;
        }

        return q;
    }
}
