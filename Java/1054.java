class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : barcodes){
            map.merge(n, 1, Integer::sum);
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int key : map.keySet()){
            maxheap.offer(new int[]{map.get(key), key});
        }

        int i = 0;
        int[] prev = new int[2];
        while(!maxheap.isEmpty()){
            int[] cur = maxheap.poll();
            ans[i++] = cur[1];
            cur[0]--;
            if (prev[0] > 0){
                maxheap.offer(prev);
            }
            prev = cur;
        }

        return ans;
    }
}
