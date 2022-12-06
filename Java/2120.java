class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        int[][] path = new int[s.length() + 1][2];
        for (int i = 1; i <= s.length(); i++){
            int x = 0, y = 0;
            switch(s.charAt(i - 1)){
                case 'R': y++; break;
                case 'L': y--; break;
                case 'U': x--; break;
                case 'D': x++; break;
                default: break;
            }

            path[i][0] = path[i - 1][0] + x;
            path[i][1] = path[i - 1][1] + y;
        }

        int dx = Math.min(startPos[0], n - startPos[0] - 1);
        int dy = Math.min(startPos[1], n - startPos[1] - 1);
        int d = Math.min(dx, dy);

        for (int i = 0, j = d; i < ans.length; i++, j = Math.min(i + d, ans.length)){
            int x = 0, y = 0;
            while(valid(x, y, n) && j < ans.length){
                j++;
                x = path[j][0] - path[i][0] + startPos[0];
                y = path[j][1] - path[i][1] + startPos[1];
            }
            int adj = valid(x, y, n)? 0 : -1;
            ans[i] = j - i + adj;
        }

        return ans;
    }

    private boolean valid(int x, int y, int n){
        return x < n && x >= 0 && y < n && y >= 0;
    }
}
