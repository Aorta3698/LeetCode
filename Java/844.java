class Solution {
    public boolean backspaceCompare(String s, String t) {
        return get(s).equals(get(t));
    }

    private String get(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if (ch == '#' && !stack.isEmpty()){
                stack.pop();
            }
            if (ch != '#'){
                stack.push(ch);
            }
        }
        char[] ans = new char[stack.size()];
        while (!stack.isEmpty()){
            ans[stack.size() - 1] = stack.pop();
        }
        return String.valueOf(ans);
    }
}

// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         return transform(s).equals(transform(t));
//     }

//     private String transform(String s){
//         Deque<Character> stack = new ArrayDeque<>();
//         for (char ch : s.toCharArray()){
//             if (ch == '#' && !stack.isEmpty()) stack.pop();
//             else if (ch != '#') stack.push(ch);
//         }

//         return stack.toString();
//     }
// }
