class Solution {
    public boolean isTransformable(String s, String t) {
        if (!Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray())){
            return false;
        }
        Queue<Integer>[] queue = new ArrayDeque[10];
        Arrays.setAll(queue, o -> new ArrayDeque<>());
        for (int i = 0; i < s.length(); i++){
            queue[s.charAt(i) - '0'].offer(i);
        }
        for (char ch : t.toCharArray()){
            for (int i = 0; i < ch - '0'; i++) if (!queue[i].isEmpty() && queue[ch - '0'].peek() > queue[i].peek()){
                return false;
            }
            queue[ch - '0'].poll();
        }
        return true;
    }
}
