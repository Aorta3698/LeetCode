class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length()-1; i >= 0; --i){
            char digit = num.charAt(i);
            if (digit == '2' || digit == '3' || digit == '4' || digit == '5' || digit == '7')
                return false;
            if (digit == '6') sb.append('9');
            else if (digit == '9') sb.append('6');
            else sb.append(digit);
        }

        return sb.toString().equals(num);
    }
}
