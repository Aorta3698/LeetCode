class Solution {
    public int fib(int n) {
        int a = 0, b = 1;
        while(n-->0){
            b += a;
            a = b-a;
        }
        return a;
    }
}
