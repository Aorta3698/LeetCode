class Solution {
    public String multiply(String num1, String num2) {
        int[] m = new int[num1.length()*num2.length()];

        for (int i = 0; i < num2.length(); i++){
            int digit = num2.charAt(i) - '0';
            int shift = num2.length() - i - 1;
            for(int j = 0; j < num1.length(); j++){
                m[shift+j] += (num1.charAt(num1.length()-1-j) - '0') * digit;
            }
        }

        for (int i = 0; i < m.length-1; i++){
            m[i+1] += m[i]/10;
            m[i] = m[i]%10;
        }

        StringBuilder sb = new StringBuilder();
        boolean filler = true;
        for (int i = m.length-1; i >= 0; i--){
            if (m[i] == 0 && filler) continue;

            filler = false;
            sb.append(m[i]);
        }

        return sb.length() == 0? "0" : sb.toString();
    }
}
