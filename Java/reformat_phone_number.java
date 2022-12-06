class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int num = 0, n = number.length();
        for (char ch : number.toCharArray())
            if (Character.isDigit(ch))
                num++;

        int r = num % 3;
        for (char ch : number.toCharArray()){
            if (!Character.isDigit(ch)) continue;
            sb.append(ch);
            if (--num == 0) break;
            if (!(r == 1 && num == 1) && num % 3 == r) sb.append('-');
            if (r == 1 && num == 2) sb.append('-');
        }

        return sb.toString();
    }
}
