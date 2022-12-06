class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sr = startPos[0];
        int sc = startPos[1];
        int hr = homePos[0];
        int hc = homePos[1];

        int ans = 0;
        if (ans == 0 && sr >= hr && sc >= hc){
            for (int i = sr; i > hr; i--) ans += rowCosts[i-1];
            for (int i = sc; i > hc; i--) ans += colCosts[i-1];
        }

        if (ans == 0 && sr >= hr && sc <= hc){
            for (int i = sr; i > hr; i--) ans += rowCosts[i-1];
            for (int i = sc; i < hc; i++) ans += colCosts[i+1];
        }
        if (ans == 0 && sr <= hr && sc >= hc){
            for (int i = sr; i < hr; i++) ans += rowCosts[i+1];
            for (int i = sc; i > hc; i--) ans += colCosts[i-1];
        }
        if (ans == 0 && sr <= hr && sc <= hc){
            for (int i = sr; i < hr; i++) ans += rowCosts[i+1];
            for (int i = sc; i < hc; i++) ans += colCosts[i+1];
        }

        return ans;
    }
}
