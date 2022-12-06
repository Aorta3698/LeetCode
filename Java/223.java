class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int STT = 1, END = -1;
        int[][] data = new int[4][3];
        data[0] = new int[]{STT, ax1, ax2, ay1};
        data[1] = new int[]{END, ax1, ax2, ay2};
        data[2] = new int[]{STT, bx1, bx2, by1};
        data[3] = new int[]{END, bx1, bx2, by2};
        Arrays.sort(data, Comparator.comparingInt(o -> o[3]));

        int ans = 0, d = 0, prevy = data[0][3], minx = data[0][1], maxx = data[0][2], active = maxx - minx;
        for (int i = 1; i < 4; i++){
            int min = data[i][1], max = data[i][2], y = data[i][3];
            ans += active * (y - prevy);
            if (data[i][0] == STT){
                if (max <= maxx && max >= minx) d = min > minx? max - min : max - minx;
                if (min <= maxx && min >= minx) d = max < maxx? max - min : maxx - min;
                if (max >= maxx && min <= minx) d = maxx - minx;
                if (data[1][0] == END) d = 0;
                active += max - min - d;
            }else{
                active -= (max - min - d);
            }
            prevy = y;
        }

        return ans;
    }
}
