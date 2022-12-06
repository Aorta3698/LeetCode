class Solution {
    public boolean checkStraightLine(int[][] o) {
        int dx = o[0][0] - o[1][0], dy = o[0][1] - o[1][1], gcd = gcd(dx, dy);
        dx /= gcd; dy /= gcd;
        if (dx < 0){dx = -dx; dy = -dy;}

        boolean sameX = true, sameY = true, mis = false;
        for (int[] t : o){
            if (t[0] != o[0][0]) sameX = false;
            if (t[1] != o[0][1]) sameY = false;
            int x = t[0] - o[0][0], y = t[1] - o[0][1], g = gcd(x, y);
            if (x == 0 && y == 0) continue;
            x /= g; y /= g;
            if (x < 0){x = -x; y = -y;}
            if (x != dx || y != dy) mis = true;
            if (!sameX && !sameY && mis) return false;
        }

        return true;
    }

    private int gcd(int x, int y){
        return x == 0? y : gcd(y % x, x);
    }
}
