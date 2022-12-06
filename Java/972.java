class Solution {
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(eval(s) - eval(t)) <= 1e-9;
    }

    private double eval(String s){
        int dot = s.indexOf(".");
        if (dot == -1){
            return Double.valueOf(s);
        }
        int open = s.indexOf("(");
        int close = s.indexOf(")");
        int end = open == -1? s.length() : open;
        double whole = Double.valueOf(s.substring(0, dot));
        double non = dot+1==open||dot+1==s.length()?0d:Double.valueOf(s.substring(dot+1, end));
        double base = Math.pow(10, end - dot - 1);
        non /= base;
        if (open == -1 || open+1==close){
            return whole+non;
        }
        double decay = Math.pow(10, close-open-1);
        double re = Double.valueOf(s.substring(open+1, close));
        double gimme = 0;
        for (int i = 0; i < 10000; i++){
            gimme += re/(base*decay);
            base *= decay;
        }
        return whole + non + gimme;
    }
}
