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

https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/1810926/Java-or-Simple-Level-Order-Construction-or-91-Speed
class Codec {
    public String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            sb.append(cur.val + (cur.children.size() << 14));
            sb.append(",");
            for (Node child : cur.children){
                queue.offer(child);
            }
        }

        return sb.toString();
    }

    public Node deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<Node> queue = new ArrayDeque<>();
        Node dummy = new Node(0, new ArrayList<>());
        Node parent = dummy;
        int sz = 1;

        for (String node : data.split(",")){
            int val = Integer.parseInt(node);
            Node cur = new Node(val, new ArrayList<>());

            if (--sz >= 0){
                parent.children.add(cur);
            }

            if (val >= (1 << 14)){
                queue.offer(cur);
            }

            if (sz == 0){
                parent.val %= (1 << 14);
                parent = queue.poll();
                if (parent == null) break;
                sz = parent.val >> 14;
            }
        }

        return dummy.children.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
