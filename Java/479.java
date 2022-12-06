class Solution {
    public int largestPalindrome(int n) {
        int d = (int)Math.pow(10, n), cur = d-1;
        for (;n>1;--cur){
            long p = 1L * d * cur + Integer.parseInt(new StringBuilder(""+cur).reverse().toString());
            for (int i = d-1; 1L*i*i>=p; i-=2){
                if (p % i == 0){
                    return (int)(p%1337);
                }
            }
        }
        return 9;
    }
}
