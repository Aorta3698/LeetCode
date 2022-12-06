class Solution {
    public int[] recoverArray(int n, int[] sums) {
        var map = new PriorityQueue<Integer>();
        for (int s : sums){
            map.offer(s);
        }
        int[] ans = new int[n];
        int idx = 0;
        while(map.size()>1){
            int a = map.poll();
            int b = map.peek();
            int d = b-a;
            map.offer(a);
            var S = new PriorityQueue<Integer>(); // superset   (including)
            var T = new PriorityQueue<Integer>(); // target set (excluding)
            while(map.size()>0){
                a = map.poll();
                S.offer(a+d);
                T.offer(a);
                map.remove(a+d);
            }
            if (T.contains(0)){
                ans[idx++]=d;
                map=T;
            }else{
                ans[idx++]=-d;
                map=S;
            }
        }
        return ans;
    }
}
