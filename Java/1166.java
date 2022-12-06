class FileSystem {

    Set<Integer> seen;
    Trie root;
    public FileSystem() {
        seen = new HashSet<>();
        root = new Trie();
    }

    public boolean createPath(String path, int value) {
        if (seen.contains(value)) return false;
        seen.add(value);
        Trie cur = root;
        for (char ch : path.toCharArray()){
            if (ch == '/' && cur != root && cur.val == -1) return false;
            if (cur.nodes[ch] == null){
                cur.nodes[ch] = new Trie();
            }
            cur = cur.nodes[ch];
        }
        if (cur.val != -1) return false;
        cur.val = value;
        return true;
    }

    public int get(String path) {
        Trie cur = root;
        for (char ch : path.toCharArray()){
            if (cur.nodes[ch] == null) return -1;
            cur = cur.nodes[ch];
        }
        return cur.val;
    }

    private class Trie{
        Trie[] nodes = new Trie[128];
        int val = -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
