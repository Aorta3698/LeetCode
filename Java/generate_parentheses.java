class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        map.put(')', n);
        map.put('(', n);
        gen(new StringBuilder(), ans);

        return ans;
    }

    private void gen(StringBuilder sb, List<String> ans){
        if (map.get(')') == 0 && map.get('(') == 0){
            ans.add(sb.toString());
            return;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            char ch = entry.getKey();
            if (count == 0)
                continue;

            sb.append(ch);
            if (ch == '(' || isValid(sb.toString())){
                map.put(ch, count - 1);
                gen(sb, ans);
                sb.deleteCharAt(sb.length() - 1);
                map.put(ch, count);
            }else{
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(')
                stack.push('(');
            else{
                if (stack.isEmpty() || stack.pop() == ')')
                    return false;
            }
        }

        return true;
    }
}
