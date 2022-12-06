/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] cnt = new int[26], count = new int[26];
        get(root1, cnt); get(root2, count);
        return Arrays.equals(cnt, count);
    }

    private static void get(Node root, int[] count){
        if (root == null) return;
        if (Character.isLetter(root.val)) count[root.val - 'a']++;
        get(root.left, count);
        get(root.right,count);
    }
}
