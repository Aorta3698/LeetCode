https://leetcode.com/problems/decode-string/discuss/1634914/Java-or-Recursion-or-15-Lines-or-Explained
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0, openIdx = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '[' && ++count == 1) openIdx = i;
            if (arr[i] == ']' && --count == 0) {
                int start = openIdx - 1;
                while(start >= 0 && Character.isDigit(arr[start])) start--;
                int dup = Integer.parseInt(s.substring(start + 1, openIdx));
                ans.append(decodeString(s.substring(openIdx + 1, i)).repeat(dup));
                openIdx = -1;
            }
            if (openIdx == -1 && Character.isAlphabetic(arr[i])) ans.append(arr[i]);
        }

        return ans.toString();
    }
}

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '[') sb.append(stack.pop());
                stack.pop();

                int num = 0;
                int count = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    num+=(stack.pop()-'0')*Math.pow(10,count++);

                String result = sb.reverse().toString().repeat(num);
                for (char c : result.toCharArray())
                    stack.push(c);
            }else
                stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
}
