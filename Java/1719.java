// https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/discuss/2204658/Java-or-from-Root-to-Leaves-or-BitSet
class Solution {
    public int checkWays(int[][] pairs){
        int MAX = 501;
        Node[] map = new Node[MAX];
        Arrays.setAll(map, o -> new Node(o));
        for (int[] p : pairs){
            int u = p[0]-1;
            int v = p[1]-1;
            map[u].bit.set(u); map[u].bit.set(v);
            map[v].bit.set(u); map[v].bit.set(v);
        }
        int[] count = new int[MAX];
        for (int i = 0; i < MAX; i++){
            count[map[i].idx]=map[i].bit.cardinality();
        }
        Arrays.sort(map, Comparator.comparingInt(o -> -count[o.idx]));
        int sz = 0;
        int ans = 1;
        while(!map[sz].bit.isEmpty()){
            sz++;
        }
        List<Node> prev = new ArrayList<>();
        for (int i = 0; i < sz; i++){
            Node parent = findParent(prev, map[i].bit);
            if (parent == null && count[map[i].idx] != sz){
                return 0;
            }
            if (parent != null){
                BitSet tmp = (BitSet)map[i].bit.clone();
                tmp.and(parent.bit);
                int m = tmp.cardinality();
                if (m!=count[map[i].idx]){
                    return 0;
                }
                if (m==count[parent.idx]){
                    ans=2;
                }
            }
            prev.add(map[i]);
        }
        return ans;
    }

    private Node findParent(List<Node> prev, BitSet cur){
        for (int i = prev.size()-1; i>=0; i--){
            if (cur.get(prev.get(i).idx))
                return prev.get(i);
        }
        return null;
    }

    private class Node {
        BitSet bit = new BitSet();
        int idx;
        Node (int idx){
            this.idx=idx;
        }
    }
}

// class Solution {
//     public int checkWays(int[][] pairs) {
//         BitSet[] map = new BitSet[500];
//         Arrays.setAll(map, o -> new BitSet());
//         BitSet bit = new BitSet();
//         for (int[] p : pairs){
//             int u = p[0]-1;
//             int v = p[1]-1;
//             bit.set(u);
//             bit.set(v);
//             map[u].set(v);
//             map[v].set(u);
//         }
//         int[] count = new int[500];
//         for (int i = bit.nextSetBit(0); i >= 0; i=bit.nextSetBit(i+1)){
//             count[i]=map[i].cardinality();
//         }

//         return dfs(map, bit, count);
//     }

//     private int dfs(BitSet[] map, BitSet bit, int[] count){
//         int sz = bit.cardinality();
//         if (sz == 1){
//             return 1;
//         }
//         int root = -1;
//         for (int i = bit.nextSetBit(0); i >= 0; i=bit.nextSetBit(i+1)){
//             if (root==-1||count[i]>count[root]){
//                 root=i;
//             }
//         }
//         if (count[root] != sz-1){
//             return 0;
//         }
//         bit.clear(root);
//         boolean multi=false;
//         for (int i = bit.nextSetBit(0); i >= 0; i=bit.nextSetBit(i+1)){
//             map[i].clear(root);
//             if (count[i]-- == count[root]){
//                 multi=true;
//             }
//         }
//         for (int i = bit.nextSetBit(0); i >= 0; i=bit.nextSetBit(i+1)){
//             BitSet next = new BitSet();
//             findConnected(i, map, next);
//             bit.xor(next);
//             int res = dfs(map, next, count);
//             if (res == 0){
//                 return 0;
//             }
//             multi |= res >= 2;
//         }
//         return multi? 2 : 1;
//     }

//     private void findConnected(int idx, BitSet[] map, BitSet ans){
//         if (ans.get(idx)){
//             return;
//         }
//         ans.set(idx);
//         for (int i = map[idx].nextSetBit(0); i >= 0; i=map[idx].nextSetBit(i+1)){
//             findConnected(i, map, ans);
//         }
//     }
// }
