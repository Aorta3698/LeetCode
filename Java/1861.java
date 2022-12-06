class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int R = box.length, C = box[0].length;
        char[][] ans = new char[C][R];
        for (int i = 0; i < C; i++)
            for (int j = 0; j < R; j++)
                ans[i][j] = box[R - j - 1][i];

        for (int i = C - 1; i >= 0; i--){
            for (int j = 0; j < R; j++){
                if (ans[i][j] == '#'){
                    int w = i;
                    while(w < C - 1 && ans[w + 1][j] == '.') w++;
                    ans[i][j] = '.';
                    ans[w][j] = '#';
                }
            }
        }

        return ans;
    }
}
