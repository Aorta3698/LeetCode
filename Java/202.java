class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            int sum = 0;
            seen.add(n);
            while(n > 0){
                int d = n % 10;
                sum += d*d;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
