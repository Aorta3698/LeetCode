class Solution {
    public String maskPII(String s) {
        return s.contains("@")?
            email(s) : phone(s);
    }

    private String email(String s){
        String ans = "";
        boolean ok = false;
        for (int i = 0; i < s.length(); i++){
            if (i == 0 || ok){
                ans += ""+(char)(s.charAt(i) | ' ');
            }
            if (s.charAt(i) == '@'){
                ans += "*****"+(char)(s.charAt(i-1) | ' ') + "@";
                ok = true;
            }
        }
        return ans;
    }

    private String phone(String s){
        String n = "";
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                n += ""+ch;
            }
        }

        String ans = "";
        boolean[] split = new boolean[21];
        split[4] = split[7] = split[10] = true;

        for (int i = n.length() - 1; i >= 0; i--){
            int j = n.length() - i - 1;
            if (split[j]){
                ans += "-";
            }
            ans += j > 3? "*" : ""+n.charAt(i);
        }
        if (n.length() > 10){
            ans += "+";
        }

        return new StringBuilder(ans).reverse().toString();
    }
}
