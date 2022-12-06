class Solution {
    public String frequencySort(String s) {
        Item[] all = new Item[128];
        Arrays.setAll(all, o -> new Item(o));
        for (char ch : s.toCharArray()){
            all[ch].count++;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(all, Comparator.comparingInt(o -> -o.count));
        for (int i = 0; i < 128; i++){
            sb.append(String.valueOf((char)all[i].ch).repeat(all[i].count));
        }
        return sb.toString();
    }

    private class Item {
        int count;
        int ch;
        Item (int ch){
            this.ch = ch;
            count = 0;
        }
    }
}
