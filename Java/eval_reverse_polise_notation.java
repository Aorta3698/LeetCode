class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();

        for (int i = 0 ; i < tokens.length; i++){
            if (tokens[i].equals("+") || tokens[i].equals("*")
                    || tokens[i].equals("-") || tokens[i].equals("/")){
                int n = operand.pop();
                int m = operand.pop();
                switch (tokens[i]){
                    case "+" -> operand.push(m+n);
                    case "-" -> operand.push(m-n);
                    case "/" -> operand.push(m/n);
                    case "*" -> operand.push(m*n);
                };
            }else
                operand.push(Integer.parseInt(tokens[i]));
        }

        return operand.pop();
    }
}
