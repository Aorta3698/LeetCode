class Solution {
    public String removeDigit(String number, char digit) {
        int r = 0;
        for (int i = 0; i < number.length(); i++){
            if (number.charAt(i) == digit){
                r = i;
                if (i < number.length() - 1 && number.charAt(i) < number.charAt(i + 1))
                    break;
            }
        }
        return number.substring(0, r) + number.substring(r + 1);
    }
}
