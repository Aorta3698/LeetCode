class Trie {

    private Node root;
    public Trie() {
        root = new Node(false);
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++){
            boolean end = i == word.length() - 1;
            if (cur.nodes[word.charAt(i) - 'a'] == null){
                cur.nodes[word.charAt(i) - 'a'] = new Node(end);
            }
            cur = cur.nodes[word.charAt(i) - 'a'];
            if (end) cur.isWord = end;
        }
    }

    public boolean search(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                return false;
            cur = cur.nodes[ch - 'a'];
        }

        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()){
            if (cur.nodes[ch - 'a'] == null)
                return false;
            cur = cur.nodes[ch - 'a'];
        }

        return true;
    }

    private class Node{
        Node[] nodes;
        boolean isWord;

        Node(boolean isWord){
            this.isWord = isWord;
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
