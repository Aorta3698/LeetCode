class Solution {
    public String reorderSpaces(String text) {
        int space = 0, cnt = text.charAt(0) == ' '? 0 : 1;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == ' ') space++;
            if (i > 0 && arr[i - 1] == ' ' && arr[i] != ' ')
                cnt++;
        }

        cnt--;
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        int d = cnt == 0? Integer.MAX_VALUE : space / cnt;
        for (String w : words){
            if (w.isEmpty()) continue;
            sb.append(w);
            if (space > 0) sb.append(" ".repeat(Math.min(d, space)));
            space -= Math.min(d, space);
        }

        if (space > 0) sb.append(" ".repeat(space));
        return sb.toString();
    }
}
