class Solution {
    public int[] closestDivisors(int num) {
        int[] a = solve(++num);
        int[] b = solve(++num);
        return a[1] - a[0] < b[1] - b[0]? a : b;
    }

    private int[] solve(int n){
        for (int i = (int)Math.sqrt(n); true; i--){
            if (n % i == 0)
                return new int[]{i, n / i};
        }
    }
}
