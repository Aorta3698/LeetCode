https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/discuss/2018355/Java-or-MLE-BitSet-to-UnionFind-or-90-Speed
class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int[] ans = new int[parents.length];
        Node[] all = new Node[parents.length];
        int max = 0;
        for (int i = 0 ; i < nums.length; i++){
            all[i] = new Node(i, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 1; i < parents.length; i++){
            all[parents[i]].nodes.add(all[i]);
        }
        solve(all[0], ans, new UF(++max, nums));
        return ans;
    }

    private void solve(Node root, int[] ans, UF uf){
        int max = 1;
        for (Node child : root.nodes){
            solve(child, ans, uf);
            uf.union(root.val, child.val);
            max = Math.max(ans[child.idx], max);
        }
        while(max <= ans.length && uf.isConnected(max, root.val)){
            ++max;
        }
        ans[root.idx] = max;
    }

    private class Node {
        int idx;
        int val;
        List<Node> nodes;
        Node (int idx, int val){
            this.idx = idx;
            this.val = val;
            nodes = new ArrayList<>();
        }
    }

    private class UF {
        int[] rank;
        int[] parent;
        UF (int n, int[] nums){
            rank = new int[n];
            parent = new int[n];
            for (int m : nums){
                parent[m] = m;
            }
        }

        private int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }

        private void union(int x, int y){
            x = find(x); y = find(y);
            if (rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }

        private boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}

// class Solution {
//     public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
//         int[] ans = new int[parents.length];
//         Map<Integer, Node> map = new HashMap<>();
//         for (int i = 0 ; i < nums.length; i++){
//             map.put(i, new Node(i, nums[i]));
//         }
//         for (int i = 1; i < parents.length; i++){
//             map.get(parents[i]).nodes.add(map.get(i));
//         }
//         solve(map.get(0), ans);
//         return ans;
//     }

//     private BitSet solve(Node root, int[] ans){
//         BitSet bit = new BitSet();
//         if (root == null)
//             return bit;
//         int max = 1;
//         for (Node child : root.nodes){
//             bit.or(solve(child, ans));
//             max = Math.max(ans[child.idx], max);
//         }
//         bit.set(root.val);
//         ans[root.idx] = bit.nextClearBit(max);
//         return bit;
//     }

//     private class Node {
//         int idx;
//         int val;
//         List<Node> nodes;
//         Node (int idx, int val){
//             this.idx = idx;
//             this.val = val;
//             nodes = new ArrayList<>();
//         }
//     }
// }
