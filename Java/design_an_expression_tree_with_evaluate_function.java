/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder extends Node {
    private String[] postfix;

    TreeBuilder buildTree(String[] postfix) {
        this.postfix = postfix;
        return this;
    }

    @Override
    public int evaluate(){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String e : postfix){
            char ch = e.charAt(0);
            if (!Character.isDigit(ch)){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(apply(first, second, ch));
                continue;
            }

            stack.push(Integer.parseInt(e));
        }

        return stack.pop();
    }

    private int apply(int f, int s, char o){
        if (o == '*') return f * s;
        if (o == '/') return f / s;
        if (o == '+') return f + s;
        if (o == '-') return f - s;
        return -1;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
