class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        for (String s : words){
            Trie cur = root;
            for (int i = s.length()-1; i >= 0; i--){
                int ch = s.charAt(i) - 'a';
                if (cur.nodes[ch]==null){
                    cur.nodes[ch]=new Trie();
                }
                cur=cur.nodes[ch];
            }
        }
        return dfs(0, root);
    }

    int dfs(int d, Trie root){
        if (root == null){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++){
            ans += dfs(d+1, root.nodes[i]);
        }
        return ans == 0? d+1 : ans;
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        Trie(){}
    }
}
