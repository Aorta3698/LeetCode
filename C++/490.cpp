class Solution {
public:
    int dx[4]{0, 0, -1, 1};
    int dy[4]{1, -1, 0, 0};
    bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& dest) {
        int m = size(maze), n = size(maze[0]);
        bool seen[m][n];
        memset(seen, 0, sizeof(seen));
        queue<array<int, 2>> q;
        q.push({start[0], start[1]});
        seen[start[0]][start[1]]=1;

        while(!q.empty()){
            auto top = q.front();
            int x = top[0], y = top[1];
            if (dest[0] == x && dest[1] == y){
                return true;
            }
            for (int i = 0; i < 4; ++i){
                int nx = x, ny = y;
                while(nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] != 1){
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if (!seen[nx][ny]){
                    seen[nx][ny]=1;
                    q.push({nx, ny});
                }
            }
            q.pop();
        }
        return false;
    }
};
