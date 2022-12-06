class Solution {
    public int maxEqualFreq(int[] nums) {
        int ans = 1, i = 0, maxCount=0;
        int[] freq = new int[100001];
        int[] count= new int[100001];
        for (int n : nums){
            ++i;
            --freq[count[n]];
            ++count[n];
            ++freq[count[n]];
            maxCount=Math.max(maxCount, count[n]);
            if ((freq[maxCount-1]+1)*(maxCount-1)+1==i || maxCount==1 || freq[1]==1&&maxCount*freq[maxCount]+1==i){
                ans=i;
            }
        }
        return ans;
    }
}
