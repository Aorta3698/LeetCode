class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        gen(0, s, new LinkedList<>(), ans);
        return ans;
    }

    private void gen(int start, String s, LinkedList<String> p, List<List<String>> ans){
        if (start == s.length()){
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int i = start; i < s.length(); i++){
            if (check(s.substring(start, i + 1))){
                p.add(s.substring(start, i + 1));
                gen(i + 1, s, p, ans);
                p.removeLast();
            }
        }
    }

    private boolean check(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }
}
