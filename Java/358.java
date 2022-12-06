class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;

        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                maxheap.offer(new int[]{count[i], i, 0});
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new ArrayDeque<>();
        int i = 0;
        while(!maxheap.isEmpty()){
            int[] cur = maxheap.poll();
            sb.append((char)(cur[1] + 'a'));
            cur[2] = i++ + k;
            if (--cur[0] > 0){
                queue.offer(cur);
            }
            if (!queue.isEmpty() && queue.peek()[2] == i){
                maxheap.offer(queue.poll());
            }
        }

        return sb.length() == s.length()? sb.toString() : "";
    }
}
