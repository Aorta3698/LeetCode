class Solution {
    public int fib(int n) {
        if (n == 0) return 0;

        int f = 0;
        int s = 1;
        while(n-- >= 2){
            int cur = s + f;
            f = s;
            s = cur;
        }

        return s;
    }
}
