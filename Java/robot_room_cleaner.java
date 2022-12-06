/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Robot robot;
    HashSet<Map.Entry<Integer, Integer>> set;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        set = new HashSet<>();
        explore(0, 0, 0);
    }

    private void explore(int x, int y, int d){

        robot.clean();
        set.add(Map.entry(x, y));

        for (int i = 0; i < 4; i++){
            int newD = (d + i) % 4;
            int newX = x + dir[newD][0];
            int newY = y + dir[newD][1];

            if (!set.contains(Map.entry(newX, newY)) && robot.move()){
                explore(newX, newY, newD);
                back();
            }

            robot.turnRight();
        }
    }

    private void back(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
