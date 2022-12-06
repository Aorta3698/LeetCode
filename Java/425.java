https://leetcode.com/problems/word-squares/discuss/2164019/Great-Question-or-Java-40ms-or-DFS-%2B-BackTrack-%2B-Trie-or-Explained.
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Trie root = new Trie();
        for (String s : words){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch-'a']==null){
                    cur.nodes[ch-'a']=new Trie();
                }
                cur=cur.nodes[ch-'a'];
            }
            cur.isWord=true;
            cur.s = s;
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, words[0].length(), root, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int i, int end, Trie root, List<String> tmp, List<List<String>> ans){
        if (i == end){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        Trie cur = root;
        for (int j = 0; j < i; j++){
            if (cur.nodes[tmp.get(j).charAt(i) - 'a']==null)
                return;
            cur=cur.nodes[tmp.get(j).charAt(i) - 'a'];
        }
        dfs(i, end, cur, root, tmp, ans);
    }

    private void dfs(int i, int end, Trie cur, Trie root, List<String> tmp, List<List<String>> ans){
        if (i == end){
            if (cur.isWord){
                tmp.add(cur.s);
                solve(tmp.size(), end, root, tmp, ans);
                tmp.remove(tmp.size()-1);
            }
            return;
        }
        for (int j = 0; j < 26; j++){
            if (cur.nodes[j]!=null){
                dfs(i+1, end, cur.nodes[j], root, tmp, ans);
            }
        }
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        boolean isWord = false;
        String s;
        Trie(){}
    }
}
