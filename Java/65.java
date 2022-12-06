import java.math.BigDecimal;
class Solution {
    public boolean isNumber(String s) {
        try{
            new BigDecimal(s);
        }catch(Exception e){
            String msg = e.getMessage();
            return "Too many nonzero exponent digits.".equals(msg) || "Exponent overflow.".equals(msg);
        }
        return true;
    }
}
