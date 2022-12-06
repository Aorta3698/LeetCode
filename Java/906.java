https://leetcode.com/problems/super-palindromes/discuss/2353212/Java-short-solution-or-Build-it
class Solution {
    public int superpalindromesInRange(String left, String right) {
        return go(Long.parseLong(right)) - go(Long.parseLong(left)-1);
    }

    private int go(long N){
        int ans = 0;
        for (int i = 1; true; i++){
            String a = i+"";
            String b = i/10==0?"":(i/10)+"";
            int m = i%10;

            long e = Long.parseLong(a + new StringBuilder(a).reverse().toString());
            long o = Long.parseLong(b + m + new StringBuilder(b).reverse().toString());
            e*=e; o*=o;
            if (e > N && o > N){
                return ans;
            }
            if (e <= N){
                ans += ok(new String(""+e));
            }
            if (o <= N){
                ans += ok(new String(""+o));
            }
        }
    }

    private int ok(String a){
        return a.equals(new StringBuilder(a).reverse().toString())? 1 : 0;
    }
}
