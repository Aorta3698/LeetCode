class Solution {
    public String entityParser(String text) {
        String[] in  = new String[]{"", "&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
        char[] out = new char[]{'\u0000', '"', '\'', '&', '>', '<', '/'};
        int[] mark = new int[text.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < in.length; i++){
            int cur = text.indexOf(in[i], 0);
            while(cur >= 0){
                mark[cur++] = i;
                cur = text.indexOf(in[i], cur);
            }
        }
        for (int i = 0; i < text.length(); i++){
            if (mark[i] > 0){
                sb.append(out[mark[i]]);
                i += in[mark[i]].length() - 1;
            }else{
                sb.append(text.charAt(i));
            }
        }

        return sb.toString();
    }
}
