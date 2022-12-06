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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> one = new ArrayDeque<>();
        Deque<TreeNode> two = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        while((!one.isEmpty() || root1 != null) && (!two.isEmpty() || root2 != null)){
            while(root1 != null){
                one.push(root1);
                root1 = root1.left;
            }

            while(root2 != null){
                two.push(root2);
                root2 = root2.left;
            }

            if (one.peek().val <= two.peek().val){
                root1 = one.pop();
                ans.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = two.pop();
                ans.add(root2.val);
                root2 = root2.right;
            }
        }

        getRemain(root1, one, ans);
        getRemain(root2, two, ans);

        return ans;
    }

    private void getRemain(TreeNode root, Deque<TreeNode> stack, List<Integer> ans){
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
    }
}
