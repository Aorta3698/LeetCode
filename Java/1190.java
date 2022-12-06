class Solution {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (arr[i] == '(') stack.push(i);
            if (arr[i] == ')'){
                int lo = stack.pop() + 1, hi = i - 1;
                while(lo < hi){
                    char tmp = arr[lo];
                    arr[lo] = arr[hi];
                    arr[hi] = tmp;
                    lo++; hi--;
                }
            }
        }

        for (char ch : arr)
            if (Character.isLetter(ch))
                sb.append(ch);

        return sb.toString();
    }
}
