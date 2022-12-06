https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/1810690/Java-or-Walk-The-Tree.
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        return dfs(0, nodes) == nodes.length && preorder.endsWith(",#,#") || preorder.equals("#");
    }

    private int dfs(int idx, String[] nodes){
        if (idx == nodes.length) return idx;
        if (nodes[idx++].equals("#")) return idx;
        idx = dfs(idx, nodes);
        idx = dfs(idx, nodes);
        return idx;
    }
}
