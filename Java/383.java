class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 'a'; i <= 'z'; i++){
            int c = i;
            if (ransomNote.chars().filter(o -> o == c).count() > magazine.chars().filter(o -> o == c).count()){
                return false;
            }
        }
        return true;
    }
}
