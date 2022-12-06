/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        List<String> l = new ArrayList<>();
        uniquePath(root, new StringBuilder(), l);
        for (String s : l)
            sum+=Integer.parseInt(s);

        return sum;

        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // int sum = 0;

        // while(!stack.isEmpty()){
        //     TreeNode cur = stack.pop();
        //     if (cur == null) continue;
        //     for (int i : d(cur))
        //         sum+=(int)Math.pow(10, i)*cur.val;
        //     stack.push(cur.left);
        //     stack.push(cur.right);
        // }

        // return sum;
    }

    private void uniquePath(TreeNode root, StringBuilder sb, List<String> l){
        if (root == null) return;

        sb.append(root.val);

        if (root.right == null && root.left == null){
            l.add(sb.toString());
            return;
        }

        StringBuilder sbR = new StringBuilder(sb);
        StringBuilder sbL = new StringBuilder(sb);
        uniquePath(root.right, sbR, l);
        uniquePath(root.left, sbL, l);
    }

    // private List<Integer> d(TreeNode root){
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     List<Integer> l = new ArrayList<>();

    //     int level = 0;
    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++){
    //             TreeNode cur = queue.poll();
    //             if (cur.left == null && cur.right == null)
    //                 l.add(level);
    //             else if (cur.left == null)
    //                 queue.offer(cur.right);
    //             else if (cur.right == null)
    //                 queue.offer(cur.left);
    //             else{
    //                 queue.offer(cur.left);
    //                 queue.offer(cur.right);
    //             }
    //         }
    //         level++;
    //     }

    //     return l;
    // }
}
