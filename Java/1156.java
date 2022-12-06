class Solution {
    public int maxRepOpt1(String text) {
        Item[] left = new Item[text.length()];
        Item[] right= new Item[text.length()];
        int[] count = new int[128];
        int lc = 0, rc = 0;
        for (int i = 0; i < text.length(); i++){
            int j = text.length() - 1 - i;
            if (i > 0 && text.charAt(i) != text.charAt(i - 1)){
                lc = 0;
            }
            if (i > 0 && text.charAt(j) != text.charAt(j + 1)){
                rc = 0;
            }
            left[i] = new Item(text.charAt(i), ++lc);
            right[j]= new Item(text.charAt(j), ++rc);
            count[text.charAt(i)]++;
        }

        int ans = 0;
        for (int i = 0; i < text.length(); i++){
            char prev = i == 0? '.' : left[i - 1].ch;
            char next = i == text.length() - 1? ',' : right[i + 1].ch;
            lc = i == 0? 0 : left[i - 1].count;
            rc = i == text.length() - 1? 0 : right[i + 1].count;
            int cur = 1;
            if (prev == next){
                cur = lc + rc + (lc + rc == count[prev]? 0 : 1);
            }else if (lc > rc){
                cur = lc + (lc == count[prev]? 0 : 1);
            }else if (rc > lc){
                cur = rc + (rc == count[next]? 0 : 1);
            }else if (rc < count[next]){
                cur = rc + 1;
            }else if (lc < count[prev]){
                cur = lc + 1;
            }else{
                cur = Math.max(1, lc);
            }
            ans = Math.max(ans, cur);
        }

        return ans;
    }

    private class Item{
        char ch;
        int count;
        Item (char ch, int count){
            this.count = count;
            this.ch = ch;
        }
    }
}
