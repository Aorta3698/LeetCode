class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0){
            long[] ans = new long[3];
            ans[1] = num / 3;
            ans[0] = ans[1] - 1;
            ans[2] = ans[1] + 1;
            return ans;
        }else{
            return new long[]{};
        }
    }
}
