class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Ball> queue = new LinkedList<>();
        queue.offer(new Ball(ball[0], ball[1], 0, new StringBuilder()));

        int[][] best = new int[maze.length][maze[0].length];
        for (int[] i : best) Arrays.fill(i, Integer.MAX_VALUE);

        Comparator<Map.Entry<String, Integer>> comp = Comparator.comparingInt(a -> a.getValue());
        comp = comp.thenComparing((a, b) -> a.getKey().compareTo(b.getKey()));
        PriorityQueue<Map.Entry<String, Integer>> cand = new PriorityQueue<>(comp);

        while(!queue.isEmpty()){
            Ball cur = queue.poll();
            int r = cur.row;
            int c = cur.col;
            int step = cur.step;
            StringBuilder path = cur.getPath();

            int idx = 0; // down, right, up, left
            for (int[] d : dirs){
                int nr = r;
                int nc = c;
                int nStep = step;
                char direction = switch(idx){
                    case 0 : yield 'd';
                    case 1 : yield 'r';
                    case 2 : yield 'u';
                    case 3 : yield 'l';
                    default : throw new IllegalArgumentException();
                };
                StringBuilder nPath = new StringBuilder(path);
                nPath.append(direction);
                idx++;
                while(nr+d[0] >= 0 && nr+d[0] < maze.length && nc+d[1] >= 0 && nc+d[1] < maze[0].length
                        && maze[nr+d[0]][nc+d[1]] != 1){
                    nr += d[0];
                    nc += d[1];
                    nStep++;

                    if (nr == hole[0] && nc == hole[1]){
                        if (nStep <= best[nr][nc]) {
                            cand.offer(Map.entry(nPath.toString(), nStep));
                            best[nr][nc] = nStep;
                            break;
                        }
                    }
                }

                if (nr == hole[0] && nc == hole[1] || nr == r && nc == c || nStep > best[nr][nc])
                    continue;
                best[nr][nc] = nStep;
                queue.offer(new Ball(nr, nc, nStep, nPath));
            }
        }

        return cand.isEmpty()? "impossible" : cand.poll().getKey();
    }

    private class Ball{
        int row;
        int col;
        int step;
        StringBuilder path;

        Ball(int r, int c, int step, StringBuilder path){
            row = r;
            col = c;
            this.step = step;
            this.path = path;
        }

        private StringBuilder getPath(){
            return path;
        }

        private int getStep(){
            return step;
        }
    }
}
