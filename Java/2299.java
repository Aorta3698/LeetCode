class Solution {
    public boolean strongPasswordCheckerII(String password) {
        String special = "!@#$%^&*()-+";
        boolean upper = false, lower = false, digit = false, sp = false;
        for (int i = 0; i < password.length(); i++){
            if (i > 0 && password.charAt(i) == password.charAt(i-1)){
                return false;
            }
            if (Character.isUpperCase(password.charAt(i))){
                upper = true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                lower = true;
            }
            if (Character.isDigit(password.charAt(i))){
                digit = true;
            }
            if (special.contains(""+password.charAt(i))){
                sp = true;
            }
        }
        return digit && lower && upper && sp && password.length() >= 8;
    }
}
