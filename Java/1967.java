class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String s : patterns){
            if (word.contains(s)){
                ans++;
            }
        }
        return ans;
    }
}
