class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int remain = 0;
        int count = 0;
        for (char ch : s.toCharArray()){
            if (ch==letter){
                remain++;
            }
        }
        for (int i = 0; i < s.length(); i++){
            while(!stack.isEmpty()&&s.charAt(i)<stack.peek()&&s.length()-i+stack.size()>k&&count-(stack.peek()==letter?1:0)+remain>=repetition){
                if (stack.pop()==letter){
                    count--;
                }
            }
            if (s.charAt(i)==letter){
                remain--;
                count++;
            }
            stack.push(s.charAt(i));
        }
        int other = k-repetition;
        while(repetition>0||other>0){
            char cur = stack.pollLast();
            if (cur==letter && repetition>0){
                repetition--;
                sb.append(cur);
            }else if(other>0){
                other--;
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
