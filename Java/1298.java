class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int HOLD=1;
        int KEY =2;
        int USED=-1;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < status.length; i++){
            if (status[i]==1){
                status[i]=1<<KEY;
            }
        }
        for (int b : initialBoxes){
            if ((status[b]&(1<<KEY))>0){
                queue.offer(b);
                status[b]=USED;
            }else{
                status[b]|=1<<HOLD;
            }
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int b : containedBoxes[cur]){
                int s = status[b];
                if (s==USED){
                    continue;
                }
                if ((s&(1<<KEY))>0){
                    status[b]=USED;
                    queue.offer(b);
                    continue;
                }
                if ((s&(1<<HOLD))==0){
                    status[b]|=1<<HOLD;
                }
            }
            for (int k : keys[cur]){
                int s = status[k];
                if (s==USED){
                    continue;
                }
                if ((s&(1<<HOLD))>0){
                    queue.offer(k);
                    status[k]=USED;
                    continue;
                }
                if ((s&(1<<KEY))==0){
                    status[k]|=1<<KEY;
                }
            }
            ans += candies[cur];
        }
        return ans;
    }
}
