class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            sb.append(c);
            if (c == ch){
                sb.reverse().append(word.substring(i + 1));
                break;
            }
        }

        return sb.toString();
    }
}
