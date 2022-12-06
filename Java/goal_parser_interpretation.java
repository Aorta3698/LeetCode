class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);
            if (ch == 'G'){
                sb.append('G');
                continue;
            }

            if (ch == '(' && command.charAt(i + 1) == ')'){
                sb.append('o');
                i++;
                continue;
            }

            sb.append('a');
            sb.append('l');
            i+=3;
        }

        return sb.toString();
    }
}
