class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        for (char ch : key.toCharArray()){
            if (ch == ' ') continue;
            map.putIfAbsent(ch, (char)(map.size()+'a'));
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()){
            if (ch == ' '){
                sb.append(' ');
            }else
            sb.append(map.get(ch));
        }
        return sb.toString();
    }
}
