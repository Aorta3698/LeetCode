https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/1683920/Java-Trie-Concise-25-Lines-with-Comments
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int ans = 0, max = 0, depth = 0;
        for (int n : nums) max = Math.max(n, max);
        for (;max > 0; max >>= 1) depth++;

        for (int n : nums){
            int sum = 0;
            Trie cur = root, tmp = cur;
            for (int i = depth - 1; i >= 0; i--){
                sum <<= 1;
                int d = (n & (1 << i)) > 0? 1 : 0;
                if (cur.nodes[d] == null) cur.nodes[d] = new Trie();
                if (tmp.nodes[1 - d] != null) sum++;
                cur = cur.nodes[d];
                tmp = sum % 2 == 0? tmp.nodes[d] : tmp.nodes[1 - d];
            }

            ans = Math.max(sum, ans);
        }

        return ans;
    }

    private class Trie{
        Trie[] nodes;
        Trie(){
            nodes = new Trie[2];
        }
    }
}
