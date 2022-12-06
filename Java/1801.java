class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int m = (int)1e9 + 7, ans = 0;
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buy = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int[] o : orders){
            if (o[2] == 0){
                while (o[1] > 0 && !sell.isEmpty() && sell.peek()[0] <= o[0]){
                    int[] s = sell.poll();
                    int take = Math.min(s[1], o[1]);
                    o[1] -= take;
                    s[1] -= take;
                    if (s[1] > 0){
                        sell.offer(s);
                    }
                }
            }else{
                while (o[1] > 0 && !buy.isEmpty() && buy.peek()[0] >= o[0]){
                    int[] b = buy.poll();
                    int take = Math.min(b[1], o[1]);
                    o[1] -= take;
                    b[1] -= take;
                    if (b[1] > 0){
                        buy.offer(b);
                    }
                }
            }
            if (o[1] > 0){
                if (o[2] == 0){
                    buy.offer(o);
                }else{
                    sell.offer(o);
                }
            }
        }

        for (int[] b : buy){
            ans = (ans + b[1]) % m;
        }
        for (int[] s : sell){
            ans = (ans + s[1]) % m;
        }

        return ans;
    }
}
