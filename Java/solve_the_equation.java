class Solution {
    public String solveEquation(String equation) {
        StringBuilder sb = new StringBuilder();
        if (equation.charAt(0) != '+' && equation.charAt(0) != '-')
            sb.append('+');
        int eIdx = equation.indexOf("=");
        sb.append(equation.substring(0, eIdx + 1));
        if (equation.charAt(eIdx+1) != '+' && equation.charAt(eIdx+1) != '-')
            sb.append('+');
        sb.append(equation.substring(eIdx + 1));

        String eq = sb.toString();
        String[] items = equation.split("[-+=]");
        int[] coe = new int[2];
        int idx = 0;
        boolean lside = true;

        for (int i = 0; i < eq.length(); i++){
            if (idx < items.length && items[idx].isEmpty()){
                idx++;
                i--;
                continue;
            }

            char ch = eq.charAt(i);
            if (ch != '-' && ch != '+' && ch != '=')
                continue;

            if (ch == '='){
                lside = false;
                continue;
            }

            String item = items[idx++];
            int pos = item.indexOf("x") != -1? 1 : 0;
            int sign = ch == '-' ? -1 : 1;
            sign = lside? sign : -sign;
            String num = item.substring(0, item.length() - pos);
            if (num.isEmpty())
                coe[1] += sign;
            else
                coe[pos] += sign * Integer.parseInt(item.substring(0, item.length()-pos));
        }

        try{
            return "x="+String.valueOf(-coe[0] / coe[1]);
        }catch(Exception e){
            return coe[0] == 0? "Infinite solutions" : "No solution";
        }
    }
}
