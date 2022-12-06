/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node ans = null;
        if (node.right != null){
            ans = node.right;
            while(ans.left != null){
                ans = ans.left;
            }
            return ans;
        }else{
            Node prev = node;
            ans = node.parent;
            while(ans != null){
                if (ans.left == prev){
                    return ans;
                }
                prev = ans;
                ans = ans.parent;
            }
        }
        return ans;
    }
}
