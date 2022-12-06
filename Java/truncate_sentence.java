class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (String w : s.split(" ")){
            sb.append(w);
            if(--k == 0) break;
            sb.append(' ');
        }

        return sb.toString();
    }
}
