class TreeAncestor {

    int[][] jump;
    public TreeAncestor(int n, int[] parent) {
        jump = new int[16][n];
        jump[0] = parent;
        for (int i = 1; i < 16; i++){
            for (int j = 0; j < n; j++){
                jump[i][j] = jump[i-1][j]==-1? -1 : jump[i-1][jump[i-1][j]];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; k > 0 && node >= 0; i++){
            if ((k&1<<i)>0){
                node = jump[i][node];
                k -= 1<<i;
            }
            //10010011000
        }
        return node;
    }

}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
