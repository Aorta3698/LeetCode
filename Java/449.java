/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                sb.append(cur.val);
                if (sz > 0){
                    sb.append(",");
                }
                if (cur.val == -1){
                    continue;
                }
                queue.offer(cur.left  == null? new TreeNode(-1) : cur.left);
                queue.offer(cur.right == null? new TreeNode(-1) : cur.right);
            }
            if (!queue.isEmpty()){
                sb.append("|");
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }

        String[] tree = data.split("\\|");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode dummy = new TreeNode();
        queue.offer(dummy);

        for (String lvl : tree){
            int cnt = 0;
            TreeNode parent = dummy;
            for (String node : lvl.split(",")){
                int val = Integer.parseInt(node);
                TreeNode cur = val >= 0? new TreeNode(val) : null;
                if (cnt++ % 2 == 0){
                    parent = queue.poll();
                    parent.left = cur;
                }else{
                    parent.right= cur;
                }
                if (val >= 0){
                    queue.offer(cur);
                }
            }
        }

        return dummy.left;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
