https://leetcode.com/problems/clumsy-factorial/discuss/1928300/1-Simple-For-Loop-Java
class Solution {
    public int clumsy(int n) {
        int ans = 0, p = -1, m = 0;
        for (int i = 0; n > 0; n--, i++){
            switch(i % 4){
                case 0 -> {ans -= m * p; m = n;}
                case 1 -> m *= n;
                case 2 -> m /= n;
                case 3 -> m -= n * p;
            }
            if (i == 4){
                p = 1;
            }
        }

        return ans - m * p;
    }
}
