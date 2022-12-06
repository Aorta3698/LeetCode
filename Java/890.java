class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String s : words){
            if (ok(s, pattern)){
                ans.add(s);
            }
        }
        return ans;
    }

    private boolean ok(String s, String pattern){
        if (s.length() != pattern.length()){
            return false;
        }
        int[] a = new int[128];
        int[] b = new int[128];
        for (int i = 0; i < s.length(); i++){
            int x = s.charAt(i), y = pattern.charAt(i);
            if (a[x] != 0 && a[x] != y || b[y] != 0 && b[y] != x){
                return false;
            }
            a[x]=y;
            b[y]=x;
        }
        return true;
    }
}
