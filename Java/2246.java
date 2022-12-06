class Solution {
    public int longestPath(int[] parent, String s) {
        Node[] all = new Node[parent.length];
        for (int i = 0; i < s.length(); i++){
            all[i] = new Node(s.charAt(i));
        }
        for (int i = 1; i < parent.length; i++){
            all[parent[i]].nodes.add(all[i]);
        }
        dfs(all[0]);
        return ans;
    }

    int ans = 1;
    private int dfs(Node root){
        int m = 0;
        int mm= 0;
        for (Node child : root.nodes){
            int res = dfs(child);
            if (root.ch == child.ch)
                continue;
            if (res > m){
                mm = m;
                m = res;
            }else if (res > mm){
                mm = res;
            }
            ans = Math.max(ans, mm + m + 1);
        }
        return m+1;
    }

    private class Node {
        char ch;
        List<Node> nodes;
        Node (char ch){
            this.ch = ch;
            nodes = new ArrayList<>();
        }
    }
}
