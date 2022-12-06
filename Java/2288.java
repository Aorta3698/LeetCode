https://leetcode.com/problems/apply-discount-to-prices/discuss/2086055/Java-Concise-Solution
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] all = sentence.split(" ");
        for (int i = 0; i < all.length; i++){
            if (all[i].charAt(0) == '$'){
                long sum = 0;
                for (int j = 1, end = all[i].length(); j < end && Character.isDigit(all[i].charAt(j)); j++){
                    sum = 10 * sum + all[i].charAt(j) - '0';
                    if (j == all[i].length() - 1){
                        all[i] = String.format("$%.2f", 1.0*sum*(100-discount)/100);
                    }
                }
            }
        }
        return String.join(" ", all);
    }
}
