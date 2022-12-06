class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;

        int[][] dirs = {{1, 0}, {0, 1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[3] - a[3]));
        queue.offer(new int[]{0, 0, dungeon[0][0], dungeon[0][0]});
        HashMap<Map.Entry<Integer, Integer>, Integer> best = new HashMap<>();

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int health = cur[2];
            int minHealth = cur[3];
            if (best.containsKey(Map.entry(x, y)) && best.get(Map.entry(x, y)) > health)
                continue;

            best.put(Map.entry(x, y), health);
            if (x == r - 1 && y == c - 1) return minHealth >= 0? 1 : Math.abs(minHealth) + 1;

            for (int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= r || ny >= c) continue;
                int nHealth = health + dungeon[nx][ny];
                int nMinHealth = Math.min(minHealth, health + dungeon[nx][ny]);
                queue.offer(new int[]{nx, ny, nHealth, nMinHealth});
            }
        }

        return -1;
    }
}
