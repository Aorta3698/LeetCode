class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            switch(ch){
                case 'a', 'e', 'i', 'o', 'u' : count = (i < s.length() / 2)? ++count : --count;
                default:
            }
        }

        return count == 0;
    }
}
