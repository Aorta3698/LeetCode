https://leetcode.com/problems/maximum-number-of-visible-points/discuss/2226102/Java-or-Reflection-and-Track-MinandMax
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int[][] A = new int[points.size()][2];
        for (int i = 0; i < points.size(); i++){
            A[i][0]=points.get(i).get(0)-location.get(0);
            A[i][1]=points.get(i).get(1)-location.get(1);
        }
        boolean can = angle <= 180;
        angle = Math.min(360-angle, angle);
        int extra = 0;
        int ans = can? 0 : Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++){
            Arrays.sort(A, Comparator.comparingDouble(o -> deg(o)));
            Deque<int[]> deque = new ArrayDeque<>();
            extra = 0;
            for (int i = 0; i < points.size(); i++){
                if (A[i][0]==0&&A[i][1]==0){
                    extra++;
                }else{
                    double prev = 0;
                    while(!deque.isEmpty() && deg(A[i]) - deg(deque.peekFirst()) > angle){
                        prev = deg(deque.pollFirst());
                    }
                    if (!can && deg(A[i])-prev>=angle){
                        ans = Math.min(ans, deque.size());
                    }
                    deque.offerLast(A[i]);
                    if (can){
                        ans = Math.max(ans, deque.size());
                    }
                }
            }
            for (int i = 0; i < points.size(); i++){
                A[i][k&1]*=-1;
            }
        }
        return can? ans+extra : points.size()-ans;
    }

    private double deg(int[] A){
        return (Math.toDegrees(Math.atan2(A[1], A[0])) + 360)%360;
    }
}
