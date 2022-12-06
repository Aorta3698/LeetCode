class Solution {
    // HashMap<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        // if (map.containsKey(n))
            // return map.get(n);

        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;
        if (n == -1) return 1/x;
        if (x == -1) return n % 2 == 0? 1 : -1;

        if (n > 0){
            n = -n;
            x = 1/x;
        }

        double h = myPow(x, n/2);

        if (n % 2 != 0){
            // map.put(n, 1/x*myPow(x, (n+1)/2)*myPow(x, (n+1)/2));
            // return map.get(n);

            return 1/x*h*h;

            // return 1/x*myPow(x, (n+1)/2)*myPow(x, (n+1)/2);
        }else{
            // map.put(n, myPow(x, n/2)*myPow(x, n/2));
            // return map.get(n);

            return h*h;

            // return myPow(x, n/2)*myPow(x, n/2);
        }
    }
}
