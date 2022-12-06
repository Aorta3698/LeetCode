/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){
                Node cur = queue.poll();
                if (cur == null) continue;
                level.add(cur.val);
                for (Node child : cur.children)
                    queue.offer(child);
            }

            if(!level.isEmpty()) ans.add(level);
        }

        return ans;
    }
}
