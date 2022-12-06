class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int[] suffix = new int[text.length() + 1];
        int[] prefix = new int[text.length() + 1];
        for (int i = 0; i < text.length(); i++){
            int j = text.length() - 1 - i;
            suffix[j] = suffix[j + 1] + (text.charAt(j) == pattern.charAt(1)? 1 : 0);
            prefix[i + 1] = prefix[i] + (text.charAt(i) == pattern.charAt(0)? 1 : 0);
        }

        long one = suffix[0], two = prefix[text.length()];
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == pattern.charAt(0)){
                one += suffix[i + 1];
            }
            if (text.charAt(i) == pattern.charAt(1)){
                two += prefix[i];
            }
        }

        return Math.max(one, two);
    }
}
