class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) return List.of("()");

        List<String> l = new ArrayList<>();

        int count = 1 << (2*n-2);
        for (int i = 0; i < count; i++){
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            for (int j = 0; j < 2*n-2; j++){
                if (checkPos(i, j))
                    sb.append('(');
                else
                    sb.append(')');
            }
            sb.append(')');

            String result = sb.toString();
            if(validate(result)) l.add(result);
        }

        return l;
    }

    private boolean validate(String s){
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == ')'){
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }else
                stack.push(ch);
        }

        return stack.isEmpty();
    }

    private boolean checkPos(int num, int pos){
        int bit = 1 << pos;
        return (bit & num) == bit;
    }
}
