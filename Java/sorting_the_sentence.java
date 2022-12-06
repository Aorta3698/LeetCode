class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        StringBuilder[] arr = new StringBuilder[words.length];
        for (String word : words)
            arr[word.charAt(word.length()-1)-'1'] =
                new StringBuilder(word.substring(0, word.length()-1));

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : arr){
            ans.append(sb);
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}
