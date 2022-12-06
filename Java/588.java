https://leetcode.com/problems/design-in-memory-file-system/discuss/2164629/Java-or-33ms-(99.8)-or-Modular-and-Concise-or-Trie-and-DFS
class FileSystem {

    Entry root;
    public FileSystem() {
        root = new Entry();
    }

    public List<String> ls(String path) {
        Entry cur = goAndMake(path);
        List<String> ans = new ArrayList<>();
        if (!cur.content.isEmpty()){
            ans.add(cur.name);
        }else{
            dfs(cur.trie, ans);
        }
        return ans;
    }

    private void dfs(Trie cur, List<String> ans){
        if (cur==null)
            return;
        if (cur.entry != null){
            ans.add(cur.entry.name);
        }
        for (int i = cur.lo; i <= cur.hi; i++){
            dfs(cur.nodes[i], ans);
        }
    }

    public void mkdir(String path) {
        goAndMake(path);
    }

    public void addContentToFile(String filePath, String content) {
        goAndMake(filePath).content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return goAndMake(filePath).content.toString();
    }

    private Entry goAndMake(String path){
        Trie cur;
        Entry curEntry = root;
        for (String s : path.split("/")){
            if (s.isEmpty()){
                continue;
            }
            cur=curEntry.trie;
            for (char ch : s.toCharArray()){
                int idx = ch-'a';
                if (cur.nodes[idx]==null){
                    cur.nodes[idx]=new Trie();
                    cur.lo = Math.min(cur.lo, idx);
                    cur.hi = Math.max(cur.hi, idx);
                }
                cur=cur.nodes[idx];
            }
            if (cur.entry==null){
                cur.entry = new Entry();
                cur.entry.name = s;
            }
            curEntry=cur.entry;
        }
        return curEntry;
    }

    private class Entry {
        Trie trie = new Trie();
        Entry(){}
        String name;
        StringBuilder content = new StringBuilder();
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        Entry entry;
        Trie(){}
        int lo = 26;
        int hi = 0;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
