class Solution {
    public boolean isRobotBounded(String instructions) {
        int d = 0, x = 0, y = 0;
        for (char ch : instructions.toCharArray()){
            if (ch == 'G'){
                if (d == 0) y++;
                if (d == 1) x++;
                if (d == 2) y--;
                if (d == 3) x--;
            }
            if (ch == 'R') d++;
            if (ch == 'L') d--;
            d = (d + 4) % 4;
        }

        return d != 0 || d == 0 && x == 0 && y == 0;
    }
}
