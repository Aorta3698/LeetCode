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
    public Node findRoot(List<Node> tree) {
        HashSet<Node> dead = new HashSet<>();
        HashSet<Node> all = new HashSet<>();
        for (Node t : tree){
            dead.addAll(t.children);
            all.add(t);
        }

        all.removeAll(dead);
        return all.iterator().next();
    }
}
