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
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<Info> stack = new ArrayDeque<>();
        int idx = traversal.length() - 1;
        while(idx >= 0){
            Info info = new Info();
            int start = idx;

            while(idx >= 0 && Character.isDigit(traversal.charAt(idx))) idx--;

            info.val = Integer.parseInt(traversal.substring(idx + 1, start + 1));

            start = idx;
            while(idx >= 0 && traversal.charAt(idx) == '-') idx--;

            info.d = start - idx;
            stack.push(info);
        }

        Info infoCur = stack.pop();
        TreeNode root = new TreeNode(infoCur.val);
        TreeNode cur = root;
        int depth = 0;
        Deque<Info> store = new ArrayDeque<>();
        HashMap<Info, TreeNode> map = new HashMap<>();
        map.put(infoCur, cur);

        while(!stack.isEmpty()){
            //go left
            while(!stack.isEmpty() && depth + 1 == stack.peek().d){
                Info infoNext = stack.pop();
                cur.left = new TreeNode(infoNext.val);
                store.push(infoCur);
                depth = infoNext.d;
                cur = cur.left;
                infoCur = infoNext;
                map.put(infoCur, cur);
            }

            //backtrack
            if (stack.isEmpty()) break;
            while(!store.isEmpty() && store.peek().d + 1 != stack.peek().d) store.pop();

            //go right one step
            infoCur = store.pop();
            Info infoNext = stack.pop();
            cur = map.get(infoCur);
            cur.right = new TreeNode(infoNext.val);
            depth = infoNext.d;
            cur = cur.right;
            infoCur = infoNext;
            map.put(infoCur, cur);
        }

        return root;
    }

    private class Info{
        int val;
        int d;

        Info(int val, int d){
            this.val = val;
            this.d = d;
        }

        Info(){}
    }
}
