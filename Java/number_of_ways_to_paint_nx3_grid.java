class Solution {
    private static final int M = (int)1e9 + 7;
    public int numOfWays(int n) {
        long two = 6;
        long three = 6;

        for (int i = 2; i <= n; i++){
            long nextThree = two * 2 + three * 2;
            two = (nextThree + two) % M;
            three = nextThree % M;
        }

        return (int)((two + three) % M);
    }
}
