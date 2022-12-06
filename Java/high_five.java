class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] i : items){
            map.computeIfAbsent(i[0], o -> new PriorityQueue<>()).add(i[1]);
            if (map.get(i[0]).size() > 5) map.get(i[0]).poll();
        }

        int[][] ans = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int sum = 0;
            PriorityQueue<Integer> pq = entry.getValue();
            while(!pq.isEmpty()) sum += pq.poll();
            ans[idx][0] = entry.getKey();
            ans[idx++][1] = sum / 5;
        }

        Arrays.sort(ans, Comparator.comparingInt(o -> o[0]));
        return ans;
    }
}
