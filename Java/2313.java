/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
https://leetcode.com/problems/minimum-flips-in-binary-tree-to-get-result/discuss/2208811/Java-Readable-and-Clean-solution
class Solution {
    final int FALSE = 0;
    final int TRUE = 1;
    final int OR  = 2;
    final int AND = 3;
    final int XOR = 4;
    final int NOT = 5;
    final int INF = (int)1e9;
    public int minimumFlips(TreeNode root, boolean result) {
        return dfs(root, result, new HashMap<>());
    }

    private int dfs(TreeNode cur, boolean want, Map<TreeNode, Map<Boolean, Integer>> memo){
        memo.putIfAbsent(cur, new HashMap<>());
        if (cur == null){
            return INF;
        }
        if (cur.val == FALSE){
            return want? 1 : 0;
        }
        if (cur.val == TRUE){
            return want? 0 : 1;
        }
        if (memo.get(cur).containsKey(want)){
            return memo.get(cur).get(want);
        }
        int ans = INF;
        int lTrue = dfs(cur.left,  true, memo);
        int rTrue = dfs(cur.right, true, memo);
        int lFalse= dfs(cur.left,  false, memo);
        int rFalse= dfs(cur.right, false, memo);
        if (want){
            switch(cur.val){
                case OR  -> ans = min(lTrue+rTrue, lTrue+rFalse, lFalse+rTrue);
                case AND -> ans = min(lTrue+rTrue);
                case XOR -> ans = min(lTrue+rFalse, lFalse+rTrue);
                case NOT -> ans = min(lFalse, rFalse);
            }
        }else{
            switch(cur.val){
                case OR  -> ans = min(lFalse+rFalse);
                case AND -> ans = min(lFalse+rFalse, lFalse+rTrue, lTrue+rFalse);
                case XOR -> ans = min(lFalse+rFalse, lTrue+rTrue);
                case NOT -> ans = min(lTrue, rTrue);
            }
        }
        memo.get(cur).put(want, ans);
        return ans;
    }

    private int min(int... values){
        int ans = INF;
        for (int i = 0; i < values.length; i++){
            ans = Math.min(values[i], ans);
        }
        return ans;
    }
}
