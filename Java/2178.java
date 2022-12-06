class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 0){
            long n = 2;
            while(finalSum - n > n){
                ans.add(n);
                finalSum -= n;
                n += 2;
            }
            ans.add(finalSum);
        }
        return ans;
    }
}
