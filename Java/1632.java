https://leetcode.com/problems/rank-transform-of-a-matrix/discuss/2436300/Java-Short-Union-Find-Solution-or-Group-By-Group-or-Fully-Commented!
class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] idx = IntStream.range(0, m*n).boxed().sorted(Comparator.comparingInt(o -> matrix[o/n][o%n])).mapToInt(o->o).toArray(); // sort by value
        int[] row = new int[m]; // previous identical number's index for a given row
        int[] col = new int[n];  // previous identical number's index for a given col
        int[] rowMin = new int[m]; // min row rank
        int[] colMin = new int[n]; // min col rank
        int[][] ans = new int[m][n];
        UF uf = new UF(m*n);
        Arrays.fill(row, -1); // at first, no valid index is present
        Arrays.fill(col, -1);
        for (int i = 0, j = 0; i < m*n; i++){
            int a = idx[i]/n, b = idx[i]%n;
            uf.union(idx[i], row[a]); // union with previous identical number's index for row
            uf.union(idx[i], col[b]); // and for col
            uf.updateRank(idx[i], Math.max(rowMin[a], colMin[b])+1); // update the rank
            row[a]=col[b]=idx[i]; // update itself to row & col for future identical number
            if (i==m*n-1 || matrix[a][b] != matrix[idx[i+1]/n][idx[i+1]%n]){ // we are at the end of identical numbers, process all the groups now.
                for (int k = j; k <= i; k++){
                    int x = idx[k]/n, y = idx[k]%n;
                    rowMin[x]=colMin[y]=ans[x][y]=uf.getRank(idx[k]); // get the rank from uf and assign it to all relevant info
                    row[x] = col[y] = -1; // backtrack row & col index info.
                }
                j = i+1; // update j (start pointer)
            }
        }
        return ans;
    }

    private class UF {
        int[] parent;
        int[] rank;
        int[] min;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            min = new int[n];
        }
        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }
        void union(int x, int y){
            if (x < 0 || y < 0 || find(x) == find(y)){
                return;
            }
            x = find(x); y = find(y);
            if (rank[x] > rank[y]){
                parent[y]=x;
                min[x]=Math.max(min[y], min[x]);
            }else{
                parent[x]=y;
                min[y]=Math.max(min[y], min[x]);
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }
        void updateRank(int x, int val){
            min[find(x)] = Math.max(val, min[find(x)]);
        }
        int getRank(int x){
            return min[find(x)];
        }
    }
}





// WORSE SOLUTION HERE
//
class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] colsRank = new int[n];
        int[] rowsRank = new int[m];
        TreeMap<Integer, Node> map = new TreeMap<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                map.computeIfAbsent(matrix[i][j], o -> new Node()).add(i, j);
            }
        }
        int[][] ans = new int[m][n];
        for (int key : map.keySet()){
            solve(map.get(key), colsRank, rowsRank, ans);
        }

        return ans;
    }

    private void solve(Node node, int[] colsRank, int[] rowsRank, int[][] ans){
        for (int x : node.xmap.keySet()){
            int y = node.xmap.get(0);
            if (ans[x][y]!=0){
                List<int[]> group = new ArrayList<>();
                int rank = dfs(x, y, node, colsRank, rowsRank, group);
                for (int[] g : group){
                    ans[g[0]][g[1]]=rank;
                    colsRank[g[1]]=rank;
                    rowsRank[g[0]]=rank;
                }
            }
        }
    }

    private int dfs(int i, int j, Node node, int[] colsRank, int[] rowsRank, List<int[]> group){
        group.add(new int[]{i, j});
        int ans = Math.max(colsRank[j], rowsRank[i])+1;
        if (rowsRank[i]!=-1){
            rowsRank[i]=-1;
            for (int y : node.xmap.get(i)){
                ans = Math.max(ans, dfs(i, y, node, colsRank, rowsRank, group));
            }
        }
        if (colsRank[j]!=-1){
            colsRank[j]=-1;
            for (int x : node.ymap.get(j)){
                ans = Math.max(ans, dfs(x, j, node, colsRank, rowsRank, group));
            }
        }
        return ans;
    }

    private class Node {
        HashMap<Integer, List<Integer>> xmap = new HashMap<>();
        HashMap<Integer, List<Integer>> ymap = new HashMap<>();
        void add(int i, int j){
            xmap.computeIfAbsent(i, o -> new ArrayList<>()).add(j);
            ymap.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
        }
    }
}

//class Solution {
//    public int[][] matrixRankTransform(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        Map<Node, List<Node>> map = new HashMap<>();
//        Node[][] grid = new Node[m][n];
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                dfs(i, j, matrix, grid, new Node(matrix[i][j]), true, true);
//                map.putIfAbsent(grid[i][j], new ArrayList<>());
//            }
//        }

//        addEdge(grid, map);
//        addEdge(rotate(grid), map);
//        Queue<Node> queue = new ArrayDeque<>();
//        for (Node node : map.keySet()){
//            if (node.ind == 0){
//                queue.offer(node);
//            }
//        }

//        int[][] ans = new int[m][n];
//        int rank = 1;
//        while(!queue.isEmpty()){
//            for (int sz = queue.size(); sz > 0; sz--){
//                Node cur = queue.poll();
//                for (int[] p : cur.p){
//                    ans[p[0]][p[1]]=rank;
//                }
//                for (Node next : map.get(cur)){
//                    if (--next.ind==0){
//                        queue.offer(next);
//                    }
//                }
//            }
//            rank++;
//        }

//        return ans;
//    }

//    private void dfs(int i, int j, int[][] matrix, Node[][] grid, Node node, boolean row, boolean col){
//        if (node.val != matrix[i][j] || grid[i][j] != null)
//            return;
//        grid[i][j]=node;
//        node.add(i, j);
//        for (int r = 0; r < grid[0].length && row; r++){
//            dfs(i, r, matrix, grid, node, false, true);
//        }
//        for (int c = 0; c < grid.length && col; c++){
//            dfs(c, j, matrix, grid, node, true, false);
//        }
//    }

//    private void addEdge(Node[][] grid, Map<Node, List<Node>> map){
//        for (Node[] g : grid){
//            HashSet<Node> set = new HashSet<>();
//            for (Node node : g){
//                set.add(node);
//            }
//            //List<Node> cur = new ArrayList<>(set);
//            List<Node> cur = new ArrayList<>();
//            for (Node node : set){
//                cur.add(node);
//            }
//            cur.sort(Comparator.comparingInt(o -> o.val));
//            for (int i = 1; i < cur.size(); i++){
//                map.get(cur.get(i-1)).add(cur.get(i));
//                cur.get(i).ind++;
//            }
//        }
//    }

//    private Node[][] rotate(Node[][] grid){
//        int m = grid.length;
//        int n = grid[0].length;
//        Node[][] next = new Node[n][m];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++){
//                next[i][j]=grid[m-1-j][i];
//            }
//        }
//        return next;
//    }

//    private class Node {
//        List<int[]> p = new ArrayList<>();
//        int val;
//        int ind;
//        Node(int val){
//            this.val=val;
//        }

//        void add(int i, int j){
//            p.add(new int[]{i, j});
//        }
//    }
//}
