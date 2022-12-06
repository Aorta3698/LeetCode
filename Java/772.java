https://leetcode.com/problems/basic-calculator/discuss/2150142/Modular-Java-Solution-for-Calculator-I-and-III-Interview-Friendly
class Solution {
    public int calculate(String s) {
        return solve(new ArrayDeque<>(s.chars().mapToObj(o->(char)o).toList()));
    }

    private int solve(Queue<Character> queue){
        int n = 0;
        int[] ans = new int[2];
        char prevOp = '+', cur = '.';
        while(!queue.isEmpty() && cur != ')'){
            cur = queue.poll();
            if (cur == ' '){
                continue;
            }else if (Character.isDigit(cur)){
                n = 10*n+cur-'0';
            }else if (cur == '('){
                n = solve(queue);
            }else{
                binop(n, prevOp, ans);
                n = 0;
                prevOp = cur;
            }
        }
        binop(n, prevOp, ans);
        return ans[0]+ans[1];
    }

    private void binop(int n, char op, int[] ans){
        switch(op){
            case '-' -> {ans[0]+=ans[1]; ans[1] = -n;}
            case '+' -> {ans[0]+=ans[1]; ans[1] = n;}
            case '*' -> ans[1]*=n;
            case '/' -> ans[1]/=n;
        };
    }
}

// class Solution {
//     public int calculate(String s) {
//         return solve(new ArrayDeque<>(s.chars().mapToObj(o->(char)o).toList()));
//     }

//     private int solve(Queue<Character> queue){
//         Deque<Integer> stack = new ArrayDeque<>();
//         int n = 0;
//         char prevOp = '+', cur = '.';
//         while(!queue.isEmpty() && cur != ')'){
//             cur = queue.poll();
//             if (cur == ' '){
//                 continue;
//             }else if (Character.isDigit(cur)){
//                 n = 10*n+cur-'0';
//             }else if (cur == '('){
//                 n = solve(queue);
//             }else{
//                 binop(n, prevOp, stack);
//                 n = 0;
//                 prevOp = cur;
//             }
//         }
//         binop(n, prevOp, stack);
//         int ans = 0;
//         for (int num : stack){
//             ans += num;
//         }
//         return ans;
//     }

//     private void binop(int n, char op, Deque<Integer> stack){
//         switch(op){
//             case '-' -> stack.push(-n);
//             case '+' -> stack.push(n);
//             case '*' -> stack.push(stack.pop()*n);
//             case '/' -> stack.push(stack.pop()/n);
//         };
//     }
// }
