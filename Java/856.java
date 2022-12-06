// optimal
class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0, ans = 0;
        char prev = '.';

        for (char ch : s.toCharArray()){
            if (ch == '('){
                depth++;
            }
            if (ch == ')'){
                depth--;
            }
            if (ch == ')' && prev == '('){
                ans += (1 << depth);
            }

            prev = ch;
        }

        return ans;
    }
}

// stack method
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<int[]> stack = new ArrayDeque<>();
        int depth = 0, ans = 0;

        for (char ch : s.toCharArray()){
            if (ch == '('){
                depth++;
            }
            if (ch == ')'){
                depth--;
                int sum = 0;
                while(!stack.isEmpty() && stack.peek()[0] > depth){
                    sum += stack.pop()[1];
                }
                sum = sum == 0? 1 : sum << 1;
                if (depth == 0){
                    ans += sum;
                }else{
                    stack.push(new int[]{depth, sum});
                }
            }
        }

        return ans;
    }
}

// recursion method
class Solution {
    public int scoreOfParentheses(String s) {
        return find(s, 0, s.length() - 1);
    }

    private int find(String s, int lo, int hi){
        if (hi == lo) return 0;
        int ans = 0;
        for (int i = lo, cnt = 0, start = lo; i <= hi; i++){
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')' && --cnt == 0){
                int val = find(s, start + 1, i - 1);
                ans += val == 0? 1 : 2 * val;
                start = i + 1;
            }
        }

        return ans;
    }
}
