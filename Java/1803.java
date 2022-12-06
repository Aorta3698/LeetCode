https://leetcode.com/problems/count-pairs-with-xor-in-a-range/discuss/2357009/Binary-Tree-(Trie)-or-O(N)-or-Java-or-Explained.
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie root = new Trie();
        int ans = 0;
        for (int n : nums){
            ans += count(n, high+1, root) - count(n, low, root);
            Trie cur=root;
            for (int i = 15; i >= 0; i--){
                if (cur.bit[(n & 1 << i)>0? 1 : 0]==null){
                    cur.bit[(n & 1 << i)>0? 1 : 0]=new Trie();
                }
                cur=cur.bit[(n & 1 << i)>0? 1 : 0];
                cur.count++;
            }
        }
        return ans;
    }

    private int count(int n, int l, Trie cur){
        int ans = 0;
        for (int i = 15; i >= 0 && cur != null; i--){
            int a = (n & 1 << i) > 0? 1 : 0;
            int b = (l & 1 << i) > 0? 1 : 0;
            int wh = a ^ b;
            if (b == 1 && cur.bit[wh^1] != null){
                ans += cur.bit[wh^1].count;
            }
            cur = cur.bit[wh];
        }
        return ans;
    }

    private class Trie {
        int count = 0;
        Trie[] bit = new Trie[2];
        Trie(){}
    }
}
