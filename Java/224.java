https://leetcode.com/problems/basic-calculator/discuss/2150142/Modular-Java-Solution-for-Calculator-I-and-III-Interview-Friendly
class Solution {
    public int calculate(String s) {
        return solve(new ArrayDeque<>(s.chars().mapToObj(o->(char)o).toList()));
    }

    private int solve(Queue<Character> queue){
        int n = 0;
        int[] ans = new int[1];
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
        return ans[0];
    }

    private void binop(int n, char op, int[] ans){
        switch(op){
            case '-' -> ans[0]-=n;
            case '+' -> ans[0]+=n;
        };
    }
}

// class Solution {
//     public int calculate(String s) {
//         return solve(new ArrayDeque<>(s.chars().mapToObj(o->(char)o).toList()));
//         // Queue<Character> queue = new ArrayDeque<>();
//         // for (char ch : s.toCharArray()){
//         //     queue.offer(ch);
//         // }
//         // return solve(queue);
//     }

//     private int solve(Queue<Character> queue){
//         int ans = 0, n = 0;
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
//                 ans += binop(n, prevOp);
//                 n = 0;
//                 prevOp = cur;
//             }
//         }
//         return ans + binop(n, prevOp);
//     }

//     private int binop(int n, char op){
//         return switch(op){
//             case '-' -> -n;
//             case '+' -> n;
//             default  -> 0;
//         };
//     }
// }

// class Solution {
//     public int calculate(String s) {
//         Queue<Character> queue = new ArrayDeque<>();
//         for (char ch : s.toCharArray()){
//             queue.offer(ch);
//         }
//         return solve(queue);
//     }

//     private int solve(Queue<Character> queue){
//         int ans = 0, sign = 1, n = 0;
//         while(!queue.isEmpty()){
//             char cur = queue.poll();
//             if (Character.isDigit(cur)){
//                 n=10*n+cur-'0';
//             }else if (cur == '('){
//                 n=solve(queue);
//             }else if (cur=='+'){
//                 ans+=n*sign;
//                 n=0;
//                 sign=1;
//             }else if (cur=='-'){
//                 ans+=n*sign;
//                 n=0;
//                 sign=-1;
//             }else if (cur==')'){
//                 break;
//             }
//         }
//         return ans+n*sign;
//     }
// }


// class Solution {
//     public int calculate(String s) {
//         s="("+s+")";
//         Deque<Integer> stack = new ArrayDeque<>();
//         int ans = 0, cur = 0, sign = 1;
//         stack.push(0);
//         for (char ch : s.toCharArray()){
//             if (Character.isDigit(ch)){
//                 cur = 10*cur+ch-'0';
//             }else if (ch == '+'){
//                 ans += sign*cur;
//                 sign=1;
//                 cur=0;
//             }else if (ch == '-'){
//                 ans += sign*cur;
//                 sign=-1;
//                 cur=0;
//             }else if (ch == '('){
//                 stack.push(ans);
//                 stack.push(sign);
//                 sign = 1;
//                 ans = 0;
//             }else if (ch == ')'){
//                 ans += sign*cur;
//                 cur = 0;
//                 ans = ans*stack.pop()+stack.pop();
//             }
//         }
//         return ans;
//     }
// }
