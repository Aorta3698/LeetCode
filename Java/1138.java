class Solution {
    public String alphabetBoardPath(String target) {
        Item[] grid = new Item[30];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                grid[5 * i + j] = new Item(i, j);
            }
        }

        Item prev = grid[0];
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()){
            Item cur = grid[ch - 'a'];
            String h = cur.c > prev.c? "R" : "L";
            String v = cur.r > prev.r? "D" : "U";
            if (ch == 'z'){
                sb.append(h.repeat(Math.abs(cur.c - prev.c)));
                sb.append(v.repeat(Math.abs(cur.r - prev.r)));
            }else{
                sb.append(v.repeat(Math.abs(cur.r - prev.r)));
                sb.append(h.repeat(Math.abs(cur.c - prev.c)));
            }
            sb.append('!');
            prev = cur;
        }

        return sb.toString();
    }

    private class Item{
        int r, c;
        Item(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
