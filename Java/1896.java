https://leetcode.com/problems/minimum-cost-to-change-the-final-value-of-expression/discuss/2333689/Shunting-yard-algorithm-or-Kind-of-Annoying-Problem-Though

class Solution {
    Deque<int[]> stack = new ArrayDeque<>();
    Deque<Character> opStack = new ArrayDeque<>();
    public int minOperationsToFlip(String expression) {
        for (char ch : expression.toCharArray()){
            if (ch == '('){
                opStack.push(ch);
            }else if (ch == ')'){
                while(opStack.peek()!='('){
                    go();
                }
                opStack.pop();
            }else if (ch == '&' || ch == '|'){
                while(!opStack.isEmpty() && opStack.peek() != '('){
                    go();
                }
                opStack.push(ch);
            }else{ // num
                stack.push(new int[]{ch, 1});
            }
        }
        while(!opStack.isEmpty()){
            go();
        }

        return stack.peek()[1];
    }

    private void go(){
        stack.push(check(opStack.pop(), stack.pop(), stack.pop()));
    }

    private int[] check(char op, int[] r, int[] l){
        int[] ans;
        int rval = r[0], rcost = r[1];
        int lval = l[0], lcost = l[1];
        if (op == '|' && rval == '0' && lval == '0'){
            ans = new int[]{'0', Math.min(rcost, lcost)};
        }else if (op == '|' && rval == '1' && lval == '0'){
            ans = new int[]{'1', 1};
        }else if (op == '|' && rval == '0' && lval == '1'){
            ans = new int[]{'1', 1};
        }else if (op == '|' && rval == '1' && lval == '1'){
            ans = new int[]{'1', 1 + Math.min(rcost, lcost)};
        }else if (op == '&' && rval == '0' && lval == '0'){
            ans = new int[]{'0', 1 + Math.min(rcost, lcost)};
        }else if (op == '&' && rval == '1' && lval == '0'){
            ans = new int[]{'0', 1};
        }else if (op == '&' && rval == '0' && lval == '1'){
            ans = new int[]{'0', 1};
        }else{ // &, 1, 1
            ans = new int[]{'1', Math.min(rcost, lcost)};
        }
        return ans;
    }
}
