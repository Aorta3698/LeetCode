import java.math.BigInteger;

class Solution {
    static BigInteger[] all = new BigInteger[10001];
    public String abbreviateProduct(int left, int right) {
        all[0] = BigInteger.ONE;
        if (all[1] == null) for (int i = 1; i < 10001; i++){
            all[i] = all[i-1].multiply(BigInteger.valueOf(i));
        }
        BigInteger cur = all[right].divide(all[left-1]);
        String s = cur.toString();
        int C = 0;
        for (int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) == '0'){
                ++C;
            }else{
                break;
            }
        }
        s = s.substring(0, s.length()-C);
        StringBuilder sb = new StringBuilder();
        if (s.length() > 10){
            String a = s.substring(0, 5);
            String b = s.substring(s.length()-5);
            sb.append(a).append("...").append(b);
        }else{
            sb.append(s);
        }
        sb.append("e").append(C);
        return sb.toString();
    }
}
