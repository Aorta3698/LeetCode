https://leetcode.com/problems/race-car/discuss/2262841/Java-or-BFS-or-boolean-3-states-or-O(3e5)
class Solution {
    public int racecar(int t) {
        int ans = 0, N = 11000, M = 14;
        boolean[][][] seen = new boolean[N][M][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        seen[0][0][0]=true;
        while(true){
            for (int sz = queue.size();sz>0;--sz){
                int[] top = queue.poll();
                int cur = top[0];
                int dir = top[2];
                int speed = (dir==0?1:-1)*(1<<top[1]);
                if (cur==t){
                    return ans;
                }
                int a = cur+speed;
                int as= top[1]+1;
                if (a < N && a >= 0 && as < M && !seen[a][as][dir]){
                    queue.offer(new int[]{a,as,dir});
                    seen[a][as][dir]=true;
                }
                if (!seen[cur][0][dir]){
                    queue.offer(new int[]{cur,0,dir^1});
                    seen[cur][0][dir]=true;
                }
            }
            ans++;
        }
    }
}
// class Solution {
//     public int racecar(int t) {
//         int ans = 0;
//         boolean a=true;
//         while(t>=1){
//             if (a){
//                 ans += cal(t);
//             }
//             for (int hi = 1<<(cal(t)-1);!a&&hi>0;hi>>=1){
//                 if ((hi&t)==0){
//                     ans += cal(hi)+1;
//                     break;
//                 }else{
//                     t-=hi;
//                 }
//             }
//             a^=true;
//         }
//         return ans;
//     }

//     private int cal(int n){
//         n |= n >> 1;
//         n |= n >> 2;
//         n |= n >> 4;
//         n |= n >> 8;
//         n |= n >> 16;
//         return (int)(Math.log(++n)/Math.log(2));
//     }
// }
