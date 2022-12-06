class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] pre = new int[fruits.length];
        for (int i = 0; i < fruits.length; i++){
            pre[i] = i==0? fruits[i][1]:fruits[i][1]+pre[i-1];
        }
        int ans = 0;
        for (int i = 0; i < fruits.length;i++){
            if (Math.abs(fruits[i][0]-startPos)>k){ // can we walk to fruit i (fruit i as the start)
                continue;
            }
            int lo = i;
            int hi = fruits.length-1;
            while(lo < hi){ // actually 2 pointers would probably work too and thus O(n)
                int mid = (lo+hi+1)>>1;
                int cost = 0;
                if (fruits[mid][0]<=startPos){
                    cost = startPos - fruits[i][0];
                }else if (fruits[i][0]>=startPos){
                    cost = fruits[mid][0]-startPos;
                }else{
                    cost = fruits[mid][0]-startPos>startPos-fruits[i][0]?
                        startPos-fruits[i][0]+fruits[mid][0]-fruits[i][0] :
                        fruits[mid][0]-startPos+fruits[mid][0]-fruits[i][0];
                }
                if (cost <= k){
                    lo=mid;
                }else{
                    hi=mid-1;
                }
            }
            ans = Math.max(ans, pre[lo]-(i==0?0:pre[i-1]));
        }
        return ans;
    }
}
