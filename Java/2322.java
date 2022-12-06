class Solution {
    int ans = Integer.MAX_VALUE;
    public int minimumScore(int[] nums, int[][] edges) {
        int xor = 0;
        Node[] nodes = new Node[nums.length];
        Arrays.setAll(nodes, o -> new Node(nums[o]));
        for (int[] e : edges){
            nodes[e[0]].children.add(e[1]);
            nodes[e[1]].children.add(e[0]);
        }
        for (int n : nums){
            xor ^= n;
        }
        dfs(0, -1, 0, xor, nodes);
        return ans;
    }

    private int dfs(int cur, int parent, int root, int xor, Node[] nodes){
        int val = nodes[cur].val;
        for (int next : nodes[cur].children){
            if (parent != next){
                val ^= dfs(next, cur, root, xor, nodes);
            }
        }
        if (cur != root){
            dfs2(root, -1, cur, root, xor, val, nodes);
        }
        return val;
    }

    private int dfs2(int cur, int parent, int ban, int root, int xor, int axor, Node[] nodes){
        if (cur==ban)
            return 0;
        int val = nodes[cur].val;
        for (int next : nodes[cur].children){
            if (parent != next){
                val ^= dfs2(next, cur, ban, root, xor, axor, nodes);
            }
        }
        if (cur != root){
            int bxor = xor^val^axor;
            ans = Math.min(ans, Math.max(val, Math.max(bxor, axor)) - Math.min(val, Math.min(bxor, axor)));
        }
        return val;
    }

    private class Node {
        int val;
        List<Integer> children = new ArrayList<>();
        Node (int val){
            this.val = val;
        }
    }
}
