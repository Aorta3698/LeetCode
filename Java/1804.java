class Trie {

    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()){
            if (cur.nodes[ch - 'a'] == null){
                cur.nodes[ch - 'a'] = new Node();
            }
            cur = cur.nodes[ch - 'a'];
            cur.prefix++;
        }
        cur.words++;
    }

    public int countWordsEqualTo(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                return 0;
            cur = cur.nodes[ch - 'a'];
        }

        return cur.words;
    }

    public int countWordsStartingWith(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                return 0;
            cur = cur.nodes[ch - 'a'];
        }

        return cur.prefix;
    }

    public void erase(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()){
            cur = cur.nodes[ch - 'a'];
            cur.prefix--;
        }
        cur.words--;
    }

    private class Node{
        Node[] nodes;
        int words = 0;
        int prefix = 0;

        Node(){
            nodes = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
