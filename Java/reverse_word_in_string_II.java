class Solution {
    public void reverseWords(char[] s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s){
            if (ch == ' '){
                list.add(sb.toString());
                sb.setLength(0);
            }else
                sb.append(ch);
        }
        list.add(sb.toString());

        Collections.reverse(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            for (char ch : list.get(i).toCharArray()){
                s[count++] = ch;
            }
            if (count <= s.length - 1)
                s[count++] = ' ';
        }
    }
}
