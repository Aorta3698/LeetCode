class Solution {
    public String greatestLetter(String s) {
        boolean[] seen = new boolean[128];
        for (char ch : s.toCharArray()){
            seen[ch]=true;
        }
        for (int i = (int)'z'; i >= (int)'a'; i--){
            if (seen[i] && seen['A'-'a'+i])
                return ""+(char)('A'-'a'+i);
        }
        return "";
    }
}
