/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node build(int[][] grid, int rowlo, int rowhi, int collo, int colhi){
        if (rowlo > rowhi || collo > colhi) return null;

        int prev = grid[rowlo][collo];
        boolean isleaf = true;
        for (int i = rowlo; i <= rowhi; i++)
            for (int j = collo; j <= colhi; j++)
                if (isleaf && grid[i][j] != prev)
                    isleaf = false;

        Node root = new Node();
        root.isLeaf = isleaf;
        root.val = prev == 1;
        if (isleaf) return root;

        int rowmid = rowlo + (rowhi - rowlo) / 2;
        int colmid = collo + (colhi - collo) / 2;
        root.topLeft = build(grid, rowlo, rowmid, collo, colmid);
        root.topRight= build(grid, rowlo, rowmid, colmid + 1, colhi);
        root.bottomLeft = build(grid, rowmid + 1, rowhi, collo, colmid);
        root.bottomRight= build(grid, rowmid + 1, rowhi, colmid + 1, colhi);
        return root;
    }
}
