class Solution {
    public int expressiveWords(String s, String[] words) {
        List<Item> st = transform(s);
        int ans = 0;

        for (String w : words){
            List<Item> cur = transform(w);
            if (cur.size() != st.size())
                continue;
            int i;
            for (i = 0; i < st.size(); i++){
                Item a = st.get(i), b = cur.get(i);
                if (a.ch != b.ch)
                    break;
                if (a.count < b.count)
                    break;
                if (a.count < 3 && b.count != a.count)
                    break;
            }
            if (i == st.size()){
                ans++;
            }
        }

        return ans;
    }

    private List<Item> transform(String s){
        List<Item> ans = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) != s.charAt(i - 1)){
                ans.add(new Item(s.charAt(i - 1), count));
                count = 0;
            }
            count++;
        }

        ans.add(new Item(s.charAt(s.length() - 1), count));
        return ans;
    }

    private class Item{
        char ch;
        int count;
        Item (char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
}
