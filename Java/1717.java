https://leetcode.com/problems/maximum-score-from-removing-substrings/discuss/1991186/Java-or-Greedy-w-Deque
class Solution {
    public int maximumGain(String s, int x, int y) {
        Deque<Character> deque = new ArrayDeque<>();
        int ans = solve(s, x > y? "ab" : "ba", Math.max(x, y), deque);
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return ans + solve(sb.toString(), x > y? "ba" : "ab", Math.min(x, y), deque);
    }

    private int solve(String s, String t, int score, Deque<Character> deque){
        for (char ch : s.toCharArray()){
            if (!deque.isEmpty() && t.equals(""+deque.peek()+ch)){
                deque.pop();
            }else{
                deque.push(ch);
            }
        }
        return score * (s.length() - deque.size()) / 2;
    }
}
