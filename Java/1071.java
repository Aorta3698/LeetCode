class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        String max = "";

        StringBuilder sb = new StringBuilder();
        for (char ch : str1.toCharArray()){
            sb.append(ch);
            if (m % sb.length() == 0 && n % sb.length() == 0){
                String cur = sb.toString();
                int len = cur.length();
                if (cur.repeat(n / len).equals(str1) && cur.repeat(m / len).equals(str2))
                    max = cur;
            }
        }

        return max;
    }
}
