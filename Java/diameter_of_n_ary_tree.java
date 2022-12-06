/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        AtomicInteger ans = new AtomicInteger(0);
        helper(root, ans);

        return ans.getAndIncrement();
    }

    private int helper(Node root, AtomicInteger ans){
        if (root == null) return 0;
        int firstL = 0;
        int secondL = 0;

        for (Node child : root.children){
            int best = child == null? 0 : helper(child, ans) + 1;
            if (firstL < best){
                secondL = firstL;
                firstL = best;
            }else if (secondL < best){
                secondL = best;
            }
        }

        ans.set(Math.max(ans.intValue(), firstL+secondL));
        return firstL;
    }
}
