class Solution {
    public int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<Character> op = new ArrayDeque<>();
        for (int i = 0, cnt = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) deque.push(--cnt == 0? ch - '0' : deque.pop() * 10 + ch - '0');
            if (ch == '+' || ch == '-') {op.offer(ch); cnt = 1;}
            if (ch == '/' || ch == '*'){
                int next = 0, j = i + 1;
                while(j < s.length()){
                    if (s.charAt(j) == '+') break;
                    if (s.charAt(j) == '-') break;
                    if (s.charAt(j) == '*') break;
                    if (s.charAt(j) == '/') break;
                    if (s.charAt(j) == ' ') {j++; continue;}
                    next *= 10;
                    next += s.charAt(j++) - '0';
                }

                i = j - 1;
                deque.push(ch == '/'? deque.pop() / next : deque.pop() * next);
            }
        }

        while(!op.isEmpty()){
            int cur = deque.pollLast(), prev = deque.pollLast();
            deque.offerLast(op.poll() == '+'? cur + prev : cur - prev);
        }

        return deque.peek();
    }
}
