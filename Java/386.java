class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(0, n, ans);
        return ans;
    }

    private void dfs(int cur, int end, List<Integer> ans){
        if (cur > end){
            return;
        }

        if (cur > 0){
            ans.add(cur);
        }
        for (int i = 0; i < 10; i++){
            if (cur > 0 || i > 0){
                dfs(10*cur+i, end, ans);
            }
        }
    }
}

// class Solution {
//     public List<Integer> lexicalOrder(int n) {
//         Trie root = new Trie();
//         for (int i = 1; i <= n; i++){
//             String s = String.valueOf(i);
//             Trie cur = root;
//             for (char ch : s.toCharArray()){
//                 if (cur.nodes[ch - '0'] == null){
//                     cur.nodes[ch - '0'] = new Trie();
//                 }
//                 cur = cur.nodes[ch - '0'];
//             }
//         }

//         List<Integer> ans = new ArrayList<>();
//         dfs(root, 0, ans);

//         return ans;
//     }

//     private void dfs(Trie cur, int n, List<Integer> ans){
//         if (cur == null){
//             return;
//         }
//         if (n > 0){
//             ans.add(n);
//         }
//         for (int i = 0; i < 10; i++){
//             dfs(cur.nodes[i], 10*n+i, ans);
//         }
//     }

//     private class Trie{
//         Trie[] nodes = new Trie[10];
//     }
// }
