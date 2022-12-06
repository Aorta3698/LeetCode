class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        for (char ch : s.toCharArray())  ans += sum(ch - 'a' + 1);
        while(--k > 0) ans = sum(ans);
        return ans;
    }

    private static int sum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
