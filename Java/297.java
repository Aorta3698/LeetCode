/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/2208311/Java-or-Clean-BFS-or-12-lines-serialized-and-15-lines-deseralized
public class Codec {

    // Encodes a tree to a single string.
    String SEP  = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                sb.append(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            sb.append(SEP);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = new TreeNode();
        Queue<TreeNode> parents = new ArrayDeque<>();
        parents.offer(root);
        boolean turn = true;
        for (String val : data.split(SEP)){
            TreeNode cur = val.isEmpty()? null : new TreeNode(Integer.parseInt(val));
            if (turn^=true){
                parents.peek().left=cur;
            }else{
                parents.poll().right=cur;
            }
            if (cur != null){
                parents.offer(cur);
            }
        }
        return root.right;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
