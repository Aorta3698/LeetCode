class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] x = new int[]{getReal(num1), getImaginery(num1)};
        int[] y = new int[]{getReal(num2), getImaginery(num2)};
        sb.append(x[0] * y[0] - x[1] * y[1]);
        sb.append('+');
        sb.append(x[0] * y[1] + x[1] * y[0]);
        sb.append('i');
        return sb.toString();
    }

    private static int getReal(String s){
        return Integer.parseInt(s.substring(0, s.indexOf("+")));
    }

    private static int getImaginery(String s){
        return Integer.parseInt(s.substring(s.indexOf("+") + 1, s.length() - 1));
    }
}
