class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> seen = new HashSet<>();
        for (String s : words){
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()){
                sb.append(codes[ch-'a']);
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }
}
