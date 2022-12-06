https://leetcode.com/problems/tree-of-coprimes/discuss/2208077/Edge-Case%3A-1-is-coprime-to-ITSELF-or-Java-pre-order-DFS-98-Speed-O(50N)
class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        boolean[][] valid = new boolean[51][51];
        for (int i = 1; i <= 50; i++){
            for (int j = i; j <= 50; j++){
                if (gcd(i, j)==1){
                    valid[i][j]=valid[j][i]=true;
                }
            }
        }

        Node[] nodes = new Node[nums.length];
        Arrays.setAll(nodes, o -> new Node(nums[o]));
        for (int[] e : edges){
            nodes[e[0]].children.add(e[1]);
            nodes[e[1]].children.add(e[0]);
        }

        Info[] info = new Info[51];
        Arrays.setAll(info, o -> new Info(-1, 0));
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        dfs(0, -1, 0, nodes, info, ans, valid);
        return ans;
    }

    private void dfs(int cur, int parent, int depth, Node[] nodes, Info[] info, int[] ans, boolean[][] valid){
        int max = -1;
        int val = nodes[cur].val;
        for (int i = 1; i <= 50; i++){
            if (valid[val][i] && info[i].idx != -1 && info[i].depth > max){
                max = info[i].depth;
                ans[cur] = info[i].idx;
            }
        }
        int d = info[val].depth;
        int i = info[val].idx;
        info[val].depth = depth;
        info[val].idx = cur;
        for (int next : nodes[cur].children){
            if (next != parent){
                dfs(next, cur, depth+1, nodes, info, ans, valid);
            }
        }
        info[val].depth=d;
        info[val].idx=i;
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b % a, a);
    }

    private class Node {
        int val;
        List<Integer> children = new ArrayList<>();
        Node (int val){
            this.val = val;
        }
    }

    private class Info {
        int idx;
        int depth;
        Info (int idx, int depth){
            this.idx = idx;
            this.depth = depth;
        }
    }
}
