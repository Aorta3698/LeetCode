https://leetcode.com/problems/design-excel-sum-formula/discuss/2206863/Java-Build-a-Directed-Graph-and-DFS
class Excel {

    Node[][] nodes;
    public Excel(int height, char width) {
        nodes = new Node[height][width-'A'+1];
        for (int i = 0; i < nodes.length; i++){
            Arrays.setAll(nodes[i], o -> new Node());
        }
    }

    public void set(int row, char column, int val) {
        nodes[row-1][column-'A'].clear();
        nodes[row-1][column-'A'].val=val;
    }

    public int get(int row, char column) {
        return dfs(nodes[row-1][column-'A']);
    }

    private int dfs(Node cur){
        if (cur.list.isEmpty()){
            return cur.val;
        }
        int ans = 0;
        for (Node next : cur.list){
            ans += dfs(next);
        }
        return ans;
    }

    public int sum(int row, char column, String[] numbers) {
        Node cur = nodes[row-1][column-'A'];
        cur.clear();
        for (String s : numbers){
            if (s.length()<=3){
                cur.list.add(nodes[parseRow(s)][parseCol(s)]);
            }else{
                String[] range = s.split(":");
                for (int i = parseRow(range[0]); i <= parseRow(range[1]); i++){
                    for (int j = parseCol(range[0]); j <= parseCol(range[1]); j++){
                        cur.list.add(nodes[i][j]);
                    }
                }
            }
        }
        return dfs(cur);
    }

    private int parseRow(String s){
        return Integer.parseInt(s.substring(1))-1;
    }

    private int parseCol(String s){
        return s.charAt(0)-'A';
    }

    private class Node {
        List<Node> list = new ArrayList<>();
        int val;
        Node(){
            this(0);
        }
        Node(int val){
            this.val = val;
        }

        void clear(){
            list.clear();
            val = 0;
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
