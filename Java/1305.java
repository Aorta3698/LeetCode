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
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>(), ans = new ArrayList<>();
        get(root1, one);
        get(root2, two);
        int i = 0, j = 0;
        while(ans.size() < one.size() + two.size()){
            if (j < two.size() && (i == one.size() || one.get(i) > two.get(j))){
                ans.add(two.get(j++));
            }else{
                ans.add(one.get(i++));
            }
        }

        return ans;
    }

    private void get(TreeNode root, List<Integer> list){
        if (root == null) return;
        get(root.left, list);
        list.add(root.val);
        get(root.right, list);
    }
}
