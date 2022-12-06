class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] sp = sentence.split(" ");
        Set<Character> vowel = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < sp.length; i++){
            char fLetter = sp[i].charAt(0);
            int sIdx = vowel.contains(Character.toLowerCase(fLetter))? 0 : 1;
            sb.append(sp[i].substring(sIdx));
            if (sIdx == 1) sb.append(fLetter);
            sb.append("ma");
            sb.append("a".repeat(i+1));
            if (i != sp.length-1) sb.append(" ");
        }

        return sb.toString();
    }
}
