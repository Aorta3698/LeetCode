/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/discuss/1811157/java-concise-simple-solution
class Solution {
    public Node intersect(Node x, Node y) {
        if (x.isLeaf) return x.val? x : y;
        if (y.isLeaf) return y.val? y : x;
        Node a = x.topLeft,
             b = x.topRight,
             c = x.bottomLeft,
             d = x.bottomRight;

        x.topLeft     = a = intersect(a, y.topLeft);
        x.topRight    = b = intersect(b, y.topRight);
        x.bottomLeft  = c = intersect(c, y.bottomLeft);
        x.bottomRight = d = intersect(d, y.bottomRight);

        if (a.isLeaf && b.isLeaf && c.isLeaf && d.isLeaf &&
            a.val == b.val && a.val == c.val && a.val == d.val){

            x.val = a.val;
            x.topLeft = x.topRight = x.bottomLeft = x.bottomRight = null;
            x.isLeaf = true;
        }

        return x;
    }
}
