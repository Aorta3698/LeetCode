https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/2199431/Java-or-Clean-O(1)-Space-Solution
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int ans = (int)1e9;
        int len = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++){
            sum += cardPoints[i];
            if (i >= len){
                sum -= cardPoints[i-len];
            }
            if (i+1 >= len){
                ans = Math.min(ans, sum);
            }
        }
        return Arrays.stream(cardPoints).sum() - ans;
    }
}
