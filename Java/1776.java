class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] ans = new double[cars.length];
        Arrays.fill(ans, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = cars.length-1; i >=0; i--){
            while(!deque.isEmpty()){
                int dp = cars[i][0]-cars[deque.peek()][0];
                int ds = cars[i][1]-cars[deque.peek()][1];
                double time = 1d*-dp/ds;
                if (ds<=0||time>=ans[deque.peek()]&&ans[deque.peek()]!=-1){
                    deque.pop();
                }else{
                    break;
                }
            }
            if (!deque.isEmpty()){
                int dp = cars[i][0]-cars[deque.peek()][0];
                int ds = cars[i][1]-cars[deque.peek()][1];
                double time = 1d*-dp/ds;
                ans[i]=time;
            }
            deque.push(i);
        }
        return ans;
    }
}

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] ans = new double[cars.length];
        Arrays.fill(ans, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = cars.length-1; i >=0; i--){
            while(!deque.isEmpty() && cars[i][1]<=cars[deque.peek()][1]){
                deque.pop();
            }
            while (!deque.isEmpty()){
                int dp = cars[i][0]-cars[deque.peek()][0];
                int ds = cars[i][1]-cars[deque.peek()][1];
                double time = 1d*-dp/ds;
                if(time>=ans[deque.peek()]&&deque.size()>1){
                    deque.pop();
                }else{
                    ans[i]=time;
                    break;
                }
            }
            deque.push(i);
        }
        return ans;
    }
}
