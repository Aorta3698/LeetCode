class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    mat[i][j] = (int)10e5;
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0,-1}};
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for (int[] d : dir){
                int x = pos[0] + d[0];
                int y = pos[1] + d[1];
                if (x < 0 || x == mat.length || y < 0 || y == mat[0].length
                        || mat[x][y] <= mat[pos[0]][pos[1]] + 1) continue;

                mat[x][y] = mat[pos[0]][pos[1]] + 1;
                queue.offer(new int[]{x, y});
            }
        }

        return mat;
    }
}

// The following solutin times out:

        // int[][] ans = new int[mat.length][mat[0].length];

        // for (int i = 0; i < mat.length; i++)
        //     for (int j = 0; j < mat[0].length; j++)
        //         ans[i][j] = mat[i][j]==0? 0:bfs(mat, i, j);

        // return ans;
    // }

    // private int bfs(int[][] arr, int row, int col){
        // Set<Integer> set = new HashSet<>();
        // Queue<int[]> queue = new LinkedList<>();
        // queue.offer(new int[]{row, col});
        // int dis = -1;

        // while(!queue.isEmpty()){
        //     dis++;
        //     int size = queue.size();
        //     for (int i = 0; i < size;i++){
        //         int[] pos = queue.poll();
        //         int x = pos[0];
        //         int y = pos[1];
        //         if (arr[x][y] == 0)
        //             return dis;

        //         if (x != 0 && set.add(10*(x-1)+y))
        //             queue.offer(new int[]{x-1,y});
        //         if (x != arr.length-1 && set.add(10*(x+1)+y))
        //             queue.offer(new int[]{x+1,y});
        //         if (y != 0 && set.add(10*x+y-1))
        //             queue.offer(new int[]{x,y-1});
        //         if (y != arr[0].length-1 && set.add(10*x+y+1))
        //             queue.offer(new int[]{x,y+1});
        //     }
        // }

        // return dis;
    // }
// }
