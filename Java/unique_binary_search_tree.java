class Solution {
    public int numTrees(int n) {
        if (n < 3) return n;

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n+1; i++){
            int sum = 0;
            for (int j = 0; j < i; j++){
                sum += arr[j]*arr[i-j-1];
            }
            arr[i] = sum;
        }

        return arr[n];
        // return (int)Math.ceil(fac(2*n)/fac(n)/fac(n+1));
    }

    // private double fac(int n){
    //     if (n == 1) return 1.0;
    //     return (double)n*fac(n-1);
    // }
}
