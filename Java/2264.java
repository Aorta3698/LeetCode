class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--){
            String cur = String.valueOf((char)(i + '0')).repeat(3);
            for (int j = 0; j < num.length() - 2; j++){
                if (cur.equals(num.substring(j, j + 3)))
                    return cur;
            }
        }
        return "";
    }
}
