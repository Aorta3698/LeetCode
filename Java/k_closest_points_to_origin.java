class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, int[]>> queue =
            new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (int i = 0; i < points.length; i++){
            int dis = 0;
            for (int j = 0; j < points[i].length; j++)
                dis+=points[i][j]*points[i][j];

            queue.offer(Map.entry(dis, points[i]));
            if (queue.size() > k) queue.poll();
        }

        int[][] ans = new int[k][2];
        while(!queue.isEmpty()){
            Map.Entry<Integer, int[]> entry = queue.poll();
            ans[--k][0] = entry.getValue()[0];
            ans[k][1] = entry.getValue()[1];
        }

        return ans;
    }
}
