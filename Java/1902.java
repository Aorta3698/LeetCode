class Solution {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        for (int n : order){
            TreeNode node = new TreeNode();
            map.put(n, node);
            Integer hi = map.ceilingKey(n + 1);
            if (hi != null && map.get(hi).left == null){
                map.get(hi).left = node;
                continue;
            }
            Integer lo = map.floorKey(n - 1);
            if (lo != null && map.get(lo).right == null){
                map.get(lo).right = node;
                continue;
            }
        }

        return dfs(map.get(order[0]));
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.right), dfs(root.left));
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
    }
}
