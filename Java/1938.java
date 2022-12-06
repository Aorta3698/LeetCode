class Solution {
    Trie root;
    List<Integer>[] map;
    List<int[]>[] Q;
    int[] ans;
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        root = new Trie();
        ans = new int[queries.length];
        map = new ArrayList[parents.length];
        Q = new ArrayList[parents.length];
        Arrays.setAll(map, o -> new ArrayList<>());
        Arrays.setAll(Q, o -> new ArrayList<>());
        int st = -1;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1){
                map[parents[i]].add(i);
                map[i].add(parents[i]);
            }else{
                st = i;
            }
        }
        for (int i = 0; i < queries.length; i++){
            Q[queries[i][0]].add(new int[]{queries[i][1], i});
        }
        dfs(st, -1);
        return ans;
    }

    private void dfs(int cur, int parent){
        Trie curTrie = root;
        for (int i = 20; i >= 0; i--){
            int b = (cur & 1<<i)>0? 1 : 0;
            if (curTrie.bit[b] == null){
                curTrie.bit[b]=new Trie();
            }
            curTrie=curTrie.bit[b];
            curTrie.count++;
        }
        for (int[] q : Q[cur]){
            curTrie = root;
            int val = q[0], idx = q[1];
            for (int i = 20; i >= 0; i--){
                int b = (val & 1<<i)>0? 1 : 0;
                if (curTrie.bit[b^1]!=null && curTrie.bit[b^1].count > 0){
                    val|=1<<i;
                    curTrie=curTrie.bit[b^1];
                }else{
                    val&=~(1<<i);
                    curTrie=curTrie.bit[b];
                }
            }
            ans[idx]=val;
        }
        for (int next : map[cur]) if (next != parent){
            dfs(next, cur);
        }
        curTrie = root;
        for (int i = 20; i >= 0; i--){
            int b = (cur & 1<<i)>0? 1 : 0;
            curTrie=curTrie.bit[b];
            curTrie.count--;
        }
    }

    private class Trie{
        int count = 0;
        Trie[] bit = new Trie[2];
        Trie(){}
    }
}
