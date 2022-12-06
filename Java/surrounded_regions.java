class Solution {
    public void solve(char[][] board) {
        Stack<int[]> stack = new Stack<>();
        int row = board.length;
        int col = board[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < row; i++ ){
            if (i == 0 || i == row-1){
                for (int j = 1; j < col-1; j++)
                    if (board[i][j] == 'O')
                        stack.push(new int[]{i, j});
            }else{
                if (board[i][0] == 'O')
                    stack.push(new int[]{i, 0});
                if (board[i][col-1] == 'O')
                    stack.push(new int[]{i, col-1});
            }

        }

        while(!stack.isEmpty()){
            int[] cell = stack.pop();
            for (int[] d : dirs){
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x <= 0 || x >= row-1 || y<=0 || y>=col-1
                        || board[x][y] == 'X' || board[x][y] == 'S')
                    continue;
                board[x][y] = 'S';
                stack.push(new int[]{x, y});
            }
        }

        for (int i = 1; i < row-1; i++){
            for (int j =1; j < col-1; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }
}
