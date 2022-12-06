class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String s : dictionary){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (cur.nodes[ch - 'a'] == null)
                    cur.nodes[ch - 'a'] = new Trie();
                cur = cur.nodes[ch - 'a'];
            }
            cur.isWord = true;
        }

        String[] strs = sentence.split(" ");
        String[] ans = new String[strs.length];
        int i = 0;
        for (String s : strs){
            StringBuilder sb = new StringBuilder();
            Trie cur = root;
            for (char ch : s.toCharArray()){
                sb.append(ch);
                if (cur != null) cur = cur.nodes[ch - 'a'];
                if (cur != null && cur.isWord) break;
            }
            ans[i++] = sb.toString();
        }

        return String.join(" ", ans);
    }

    private class Trie{
        Trie[] nodes;
        boolean isWord;
        Trie(){
            nodes = new Trie[26];
        }
    }
}
