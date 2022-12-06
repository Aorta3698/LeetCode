class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder, Comparator.comparingInt(o -> o.length()));
        for (String s : folder){
            Trie cur = root;
            for (char ch : s.toCharArray()){
                if (ch == '/' && cur.end) break;
                if (cur.nodes[ch] == null){
                    cur.nodes[ch] = new Trie();
                }
                cur = cur.nodes[ch];
            }
            if (!cur.end) ans.add(s);
            cur.end = true;
        }
        return ans;
    }

    private class Trie{
        Trie[] nodes = new Trie[128];
        boolean end = false;
    }
}
