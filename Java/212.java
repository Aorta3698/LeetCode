class Solution {
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length; n = board[0].length;
        List<String> ans = new ArrayList<>();
        Trie root = new Trie();
        for (String s : words){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch-'a']==null){
                    cur.nodes[ch-'a']=new Trie();
                }
                cur=cur.nodes[ch-'a'];
            }
            cur.word=s;
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dfs(i, j, board, root, ans, new boolean[m][n]);
            }
        }

        return ans;
    }

    private void dfs(int i, int j, char[][] board, Trie cur, List<String> ans, boolean[][] seen){
        if (i < 0 || j < 0 || i == m || j == n || seen[i][j] || (cur=cur.nodes[board[i][j]-'a'])==null)
            return;
        if (cur.word!=null){
            ans.add(cur.word);
            cur.word=null;
        }
        seen[i][j]=true;
        dfs(i+1, j, board, cur, ans, seen);
        dfs(i-1, j, board, cur, ans, seen);
        dfs(i, j+1, board, cur, ans, seen);
        dfs(i, j-1, board, cur, ans, seen);
        seen[i][j]=false;
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        String word;
    }
}
