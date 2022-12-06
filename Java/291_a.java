class Solution {
    public String removeDigit(String number, char digit) {
        int r = -1;
        for (int i = 0; i < number.length(); i++){
            if (number.charAt(i) == digit){
                if (i < number.length() - 1 && number.charAt(i) < number.charAt(i + 1)){
                    return number.substring(0, i) + number.substring(i + 1);
                } 
                r = i;
            }            
        }
        return number.substring(0, r) + number.substring(r + 1);
    }
}
