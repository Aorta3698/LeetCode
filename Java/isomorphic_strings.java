class Solution {
    public boolean isIsomorphic(String s, String t) {
        return serialize(s).equals(serialize(t));
    }

    private String serialize(String s){
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char id = 'a';
        for (char ch : s.toCharArray()){
            map.putIfAbsent(ch, id++);
            sb.append(map.get(ch));
        }

        return sb.toString();
    }
}
