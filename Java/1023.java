class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries){
            ans.add(isSub(q, pattern));
        }

        return ans;
    }

    private boolean isSub(String a, String b){
        int j = 0;
        for (int i = 0; i < a.length(); i++){
            if (Character.isUpperCase(a.charAt(i)) && (j == b.length() || b.charAt(j) != a.charAt(i)))
                return false;
            if (j < b.length() && a.charAt(i) == b.charAt(j)){
                ++j;
            }
        }

        return j == b.length();
    }
}
