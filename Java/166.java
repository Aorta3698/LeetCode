https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/1856027/Java-or-Convert-to-Long
class Solution {
    public String fractionToDecimal(int n, int d) {
        long x = Math.abs(n*1L), y = Math.abs(d*1L);
        StringBuilder sb = new StringBuilder();
        if (n < 0 && d > 0 || n > 0 && d < 0){
            sb.append('-');
        }

        Map<Long, Integer> map = new HashMap<>();
        sb.append(x / y);
        x %= y;
        if (x > 0){
            sb.append('.');
        }
        while(!map.containsKey(x)){
            map.put(x, map.size());
            x *= 10;
            if (x > 0){
                sb.append(x / y);
            }
            x %= y;
        }

        if (x > 0){
            sb.insert(sb.length() - (map.size() - map.get(x)), '(');
            sb.append(')');
        }
        return sb.toString();
    }
}
