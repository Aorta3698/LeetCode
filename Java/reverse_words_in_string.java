class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");

        for (int i = 0; i < words.length/2; i++){
            String tmp = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (String str : words)
            sb.append(str+" ");

        return sb.toString().trim();
    }
}
