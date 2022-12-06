https://leetcode.com/problems/elimination-game/discuss/1882203/Java-or-Explained-or-Stack
class Solution {
    public int lastRemaining(int n) {
        Deque<Integer> parity = new ArrayDeque<>();
        while(n > 1){
            if (parity.size() % 2 == 0){
                parity.push(-1);
            }else{
                parity.push(-(n%2));
            }
            n >>= 1;
        }

        int ans = 0;
        while(!parity.isEmpty()){
            ans = 2 * ans - parity.pop();
        }

        return ans + 1;
    }
}

// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// 2, 4, 6, 8, 10
// 4, 8
// 8
