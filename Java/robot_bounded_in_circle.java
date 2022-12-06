class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] Pos = {0, 0, 0};
        String ins = instructions.repeat(4);

        for (int i = 0; i < ins.length(); i++)
            move(Pos, ins.charAt(i));

        return Pos[0] == 0 && Pos[1] == 0 && Pos[2] == 0;
    }

    private void move(int[] pos, char instruction){
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int d = pos[2];
        if (instruction == 'G'){
            pos[0] += dirs[d][0];
            pos[1] += dirs[d][1];
        }else if (instruction == 'L'){
            pos[2] = (d + 3) % 4;
        }else if (instruction == 'R'){
            pos[2] = (d + 5) % 4;
        }
    }
}
