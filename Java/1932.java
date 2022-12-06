https://leetcode.com/problems/merge-bsts-to-create-single-bst/discuss/2467078/Java-or-Build-It-or-With-Detailed-Comments!
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> root = new HashMap<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode t : trees){
            root.put(t.val, t);
            map.put(t.val, t);
        }
        for (TreeNode t : trees){
            int L = t.left == null? 0 : t.left.val;
            int R = t.right== null? 0 : t.right.val;
            root.remove(L);
            root.remove(R);
        }
        if (root.size() != 1 || map.size() != trees.size()){
            return null;
        }
        int INF = (int)1e9;
        TreeNode r = root.values().iterator().next();
        return build(-INF, INF, r, map) && map.size() == 1? r : null;
    }

    private boolean build(int min, int max, TreeNode cur, Map<Integer, TreeNode> map){
        boolean ok = cur.val > min && cur.val < max;
        if (cur.left != null){
            cur.left = map.getOrDefault(cur.left.val, cur.left);
            map.remove(cur.left.val);
            ok &= build(min, cur.val, cur.left, map);
        }
        if (cur.right != null){
            cur.right = map.getOrDefault(cur.right.val, cur.right);
            map.remove(cur.right.val);
            ok &= build(cur.val, max, cur.right, map);
        }
        return ok;
    }
}
