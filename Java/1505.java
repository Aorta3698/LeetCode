https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/discuss/2399591/Java-or-Check-Pos-By-Pos-NOT-Digit-by-Digit
class Solution {
    public String minInteger(String num, int k) {
        StringBuilder sb = new StringBuilder();
        char[] A = num.toCharArray();
        int[] bit = new int[A.length+2];
        Queue<Integer>[] queue = new ArrayDeque[10];
        Arrays.setAll(queue, o -> new ArrayDeque<>());
        for (int i = 0; i < A.length; i++){
            queue[A[i]-'0'].offer(i);
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < 10; j++){
                if (!queue[j].isEmpty()){
                    int cost = queue[j].peek() - i + (i - sum(bit, queue[j].peek()));
                    if (cost <= k){
                        k -= cost;
                        sb.append(j);
                        add(bit, queue[j].poll(), 1);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    private void add(int[] bit, int idx, int inc){
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx]+=inc;
        }
    }

    private int sum(int[] bit, int idx){
        int ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}
