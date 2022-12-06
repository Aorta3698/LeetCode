class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while(carry > 0 || i >= 0 || j >= 0){
            int n = i >= 0? a.charAt(i) - '0' : 0;
            int m = j >= 0? b.charAt(j) - '0' : 0;
            int sum = n + m + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            i--; j--;
        }

        return sb.reverse().toString();
    }
}
