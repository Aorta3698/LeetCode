class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(0, target, 0L, 0L, 0L, '+', num, new StringBuilder(), ans);
        return ans;
    }

    private void solve(int i, int target, long sum, long prev, long cur, char prevOp, String s, StringBuilder sb, List<String> ans){
        if (i == s.length()){
            long[] res = process(cur, prevOp, sum, prev);
            if (res[0]+res[1]==target){
                ans.add(sb.toString());
            }
            return;
        }
        cur = 10*cur+s.charAt(i)-'0';
        sb.append(s.charAt(i));
        if (i==s.length()-1||cur!=0){
            solve(i+1, target, sum, prev, cur, prevOp, s, sb, ans);
        }
        long[] res = process(cur, prevOp, sum, prev);
        if (i < s.length()-1){
            for (char op : new char[]{'+', '-', '*'}){
                sb.append(op);
                solve(i+1, target, res[0], res[1], 0L, op, s, sb, ans);
                sb.setLength(sb.length()-1);
            }
        }
        sb.setLength(sb.length()-1);
    }

    private long[] process(long cur, char op, long sum, long prev){
        long[] res = new long[2];
        switch(op){
            case '+' -> {res[0]=sum+prev; res[1]=cur;}
            case '-' -> {res[0]=sum+prev; res[1]=-cur;}
            case '*' -> {res[0]=sum; res[1]=prev*cur;}
        };
        return res;
    }
}

// class Solution {
//     public List<String> addOperators(String num, int target) {
//         List<String> ans = new ArrayList<>();
//         solve(0, target, -1, num, new StringBuilder(), ans);
//         return ans;
//     }

//     private void solve(int i, int target, int st, String s, StringBuilder sb, List<String> ans){
//         if (i == s.length()){
//             String res = sb.toString();
//             if (eval(res)==target){
//                 ans.add(res);
//             }
//             return;
//         }
//         sb.append(s.charAt(i));
//         if (st == -1){
//             st = s.charAt(i)-'0';
//         }
//         if (i==s.length()-1||st!=0){
//             solve(i+1, target, st, s, sb, ans);
//         }
//         if (i < s.length()-1){
//             for (char op : new char[]{'+', '-', '*'}){
//                 sb.append(op);
//                 solve(i+1, target, -1, s, sb, ans);
//                 sb.setLength(sb.length()-1);
//             }
//         }
//         sb.setLength(sb.length()-1);
//     }

//     private long eval(String s){
//         long[] ans = new long[2];
//         long n = 0;
//         char prevOp = '+';
//         for (char ch : s.toCharArray()){
//             if (Character.isDigit(ch)){
//                 n = 10*n+ch-'0';
//             }else{
//                 binop(n, prevOp, ans);
//                 n = 0;
//                 prevOp = ch;
//             }
//         }
//         binop(n, prevOp, ans);
//         return ans[0]+ans[1];
//     }

//     private void binop(long n, char op, long[] ans){
//         switch(op){
//             case '+' -> {ans[0]+=ans[1]; ans[1]=n;}
//             case '-' -> {ans[0]+=ans[1]; ans[1]=-n;}
//             case '*' -> ans[1]*=n;
//         };
//     }
// }
