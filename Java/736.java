https://leetcode.com/problems/parse-lisp-expression/discuss/2401431/Java-Clean-Solution-Iterative
class Solution {
    Map<String, Deque<Integer>> env = new HashMap<>();
    Map<Integer, List<String>> scope = new HashMap<>();
    Deque<String> op = new ArrayDeque<>();
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<String> wait = new ArrayDeque<>();
    final String MULT = "mult", LET = "let", ADD = "add";
    public int evaluate(String expression) {
        String[] A = expression.replaceAll("\\)", "\\) ").replaceAll("\\(", "").replaceAll("\\s+", " ").split(" ");
        op.push("");
        for (String a : A){
            if (a.equals(LET) || a.equals(MULT) || a.equals(ADD)){
                op.push(a);
                wait.push("");
            }else if (a.contains(")")){
                a = a.substring(0, a.length()-1);
                int val = a.isEmpty()? stack.pop() : isVariable(a)? env.get(a).peek() : Integer.parseInt(a);
                switch(op.peek()){
                    case LET -> {stack.push(val); cleanScope();}
                    case ADD -> {stack.push(stack.pop() + val);}
                    default  -> {stack.push(stack.pop() * val);}
                };
                op.pop();
                wait.pop();
                if (op.peek().equals(LET) && !wait.peek().isEmpty()){
                    addToEnv(stack.pop());
                }
            }else if (isVariable(a)){
                switch(op.peek()){
                    case LET -> {if (!wait.peek().isEmpty()) addToEnv(env.get(a).peek()); else extendScope(a);}
                    default  -> stack.push(env.get(a).peek());
                };
            }else if (isNum(a)){
                int val = Integer.parseInt(a);
                switch(op.peek()){
                    case LET -> addToEnv(val);
                    default  -> stack.push(val);
                };
            }
        }
        return stack.pop();
    }

    private void cleanScope(){
        for (String variable : scope.remove(op.size())){
            env.get(variable).pop();
        }
    }

    private void extendScope(String a){
        scope.computeIfAbsent(op.size(), o -> new ArrayList<>()).add(a);
        wait.push(a);
    }

    private void addToEnv(int val){
        env.computeIfAbsent(wait.pop(), o -> new ArrayDeque<>()).push(val);
    }

    private boolean isNum(String a){
        return a.charAt(0) == '-' || a.chars().allMatch(Character::isDigit);
    }

    private boolean isVariable(String a){
        return a.chars().anyMatch(Character::isLetter);
    }
}
