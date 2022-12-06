class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 0) {sb.append('-'); num = -num;}

        int sub = 1;
        while(sub * 7 <= num) sub *= 7;
        while(sub > 0){
            int d = num / sub;
            num -= d * sub;
            sub /= 7;
            sb.append(d);
        }

        return sb.toString();
    }
}
