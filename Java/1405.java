class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        for (int i = 0; i < 3; i++){
            if (arr[i] > 0){
                maxheap.offer(new int[]{i, arr[i]});
            }
        }

        int prev = -1, count = 0;
        while(!maxheap.isEmpty()){
            int[] hold = maxheap.peek();
            if (hold[0] == prev && count == 2){
                maxheap.poll();
                if (maxheap.isEmpty())
                    break;
            }
            int[] cur = maxheap.poll();
            sb.append((char)('a' + cur[0]));
            if (--cur[1] > 0){
                maxheap.offer(cur);
            }
            if (prev != cur[0]){
                count = 0;
            }
            if (cur[0] != hold[0]){
                maxheap.offer(hold);
            }
            count++;
            prev = cur[0];
        }

        return sb.toString();
    }
}
