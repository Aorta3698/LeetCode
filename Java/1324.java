class Solution {
    public List<String> printVertically(String s) {
        List<String> ans = new ArrayList<>();
        String[] words = s.split(" ");
        boolean more = true;
        int pos = 0;
        while(more){
            more = false;
            StringBuilder sb = new StringBuilder();
            for (String t : words){
                if (pos >= t.length()){
                    sb.append(" ");
                }else{
                    more = true;
                    sb.append(t.charAt(pos));
                }
            }
            pos++;
            String res = sb.toString().stripTrailing();
            if (!res.isEmpty()){
                ans.add(res);
            }
        }
        return ans;
    }
}
