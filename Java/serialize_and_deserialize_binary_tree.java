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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) sb.append(node);
            else sb.append(node.val);
            sb.append(',');

            if (node == null) continue;
            stack.push(node.right);
            stack.push(node.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> l = new LinkedList<>(Arrays.asList(data.split(",")));

        return helper(l);
    }

    private TreeNode helper(LinkedList<String> l){
        String element = l.remove(); //safe because l always has two nulls at the end.
        if (element.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(element));
        root.left = helper(l);
        root.right = helper(l);

        return root;
    }

    // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     String[] arr = data.split(",");

    //     return helper(arr, new AtomicInteger(0));
    // }

    // private TreeNode helper(String[] arr, AtomicInteger idx){
    //     if (idx.intValue() >= arr.length ||
    //             arr[idx.intValue()].equals("null")) {
    //         idx.incrementAndGet();
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(Integer.valueOf(arr[idx.intValue()]));
    //     idx.incrementAndGet();
    //     root.left = helper(arr, idx);
    //     root.right = helper(arr, idx);

    //     return root;
    // }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
