https://leetcode.com/problems/escape-a-large-maze/discuss/1605464/Java-BFS-with-explanations.
class Solution {
    private static final int N = 1000000;
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<List<Integer>> blockSet = new HashSet<>();
        for (int[] b : blocked)
            blockSet.add(new ArrayList<>(List.of(b[0], b[1])));

        return check(source, target, blockSet) && check(target, source, blockSet);
    }

    private boolean check(int[] source, int[] target, HashSet<List<Integer>> blockSet){
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);

        boolean[][] seen = new boolean[401][401]; //center is 200, 200 (source)
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int adjustedR = 200 + r - source[0];
                int adjustedC = 200 + c - source[1];
                if (seen[adjustedR][adjustedC]) continue;
                if (cur[0] == target[0] && cur[1] == target[1]) return true;
                seen[adjustedR][adjustedC] = true;

                for (int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N
                            || blockSet.contains(List.of(nr, nc))) continue;
                    queue.offer(new int[]{nr, nc});
                }
            }
            step++;
            if (step > 200) return true;
        }

        return false;
    }

}
