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
    public Node expTree(String s) {
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        int[] precedence = new int[128];
        precedence['*']=precedence['/']=1;
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                stack.push(new Node(ch));
            }else if (ch == '('){
                opStack.push(ch);
            }else if (ch == ')'){
                while(opStack.peek()!='('){
                    stack.push(build(opStack, stack));
                }
                opStack.pop();
            }else{
                while(!opStack.isEmpty()&&opStack.peek()!='('&&precedence[opStack.peek()]>=precedence[ch]){
                    stack.push(build(opStack, stack));
                }
                opStack.push(ch);
            }
        }
        while(!opStack.isEmpty()){
            stack.push(build(opStack, stack));
        }
        return stack.pop();
    }

    private Node build(Deque<Character> opStack, Deque<Node> stack){
        Node r = stack.pop();
        return new Node(opStack.pop(), stack.pop(), r);
    }
}
