class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0)+1);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry entry : map.entrySet()){
            queue.offer(new int[]{(int)entry.getKey(), (int)entry.getValue()});
            if(queue.size() > k) queue.poll();
        }

        while(k-- > 0)
            ans[k] = queue.poll()[0];

        return ans;
    }
}
