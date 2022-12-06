class Solution {
    String operator = "+-*/";
    int[] cards;
    public boolean judgePoint24(int[] cards) {
        this.cards = cards;
        order['/']=order['*']=1;
        return solve(0, 0, 0, new StringBuilder());
    }

    private boolean solve(int lvl, int bal, int seen, StringBuilder sb){
        if (lvl == 4){
            return Math.abs(eval(sb.toString()) - 24) <= 1e-9;
        }

        for (int p = -1; p < 2; p++){
            if (p == 0 && 4-lvl-1 < bal || p == 1 && 4-lvl-1 < bal+1 || p == -1 && bal == 0){
                continue;
            }
            if (p == 1){
                sb.append('(');
            }
            for (int i=0; i < 4; i++){
                if ((seen & 1<<i)>0){
                    continue;
                }
                sb.append(cards[i]);
                if (p == -1){
                    sb.append(')');
                }
                for (int j = 0; j < 4 && lvl<3; j++){
                    sb.append(operator.charAt(j));
                    if (solve(lvl+1, bal+p, seen|1<<i, sb)){
                        return true;
                    }
                    sb.setLength(sb.length()-1);
                }
                if (lvl == 3 && solve(lvl+1, bal+p, seen|1<<i, sb)){
                    return true;
                }
                sb.setLength(sb.length()-(p==-1?2:1));
            }
            if (p == 1){
                sb.setLength(sb.length()-1);
            }
        }

        return false;
    }

    Deque<Character> op = new ArrayDeque<>();
    Deque<Double> stack = new ArrayDeque<>();
    int[] order = new int[128];
    private double eval(String s){
        for (char ch : s.toCharArray()){
            switch(ch){
                case '(' -> op.push(ch);
                case ')' -> {go(0); op.pop();}
                case '+','-','*','/' -> {go(ch); op.push(ch);}
                default -> stack.push((double)(ch-'0'));
            };
        }
        go(0);
        return stack.pop();
    }

    private void go(int ch){
        while(!op.isEmpty() && op.peek() != '(' && order[op.peek()] >= order[ch]){
            double r = stack.pop();
            double l = stack.pop();
            stack.push(switch(op.pop()){
                case '/': yield l/r;
                case '*': yield l*r;
                case '-': yield l-r;
                default : yield l+r;
            });
        }
    }
}
