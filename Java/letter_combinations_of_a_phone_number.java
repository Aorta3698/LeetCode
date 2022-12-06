class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();
        List<List<Character>> alphabet = new ArrayList<>();

        for (char ch : digits.toCharArray()){
            int dis = ch - '2';
            int offset = (ch >= '8')? 1 : 0;
            List<Character> each = new ArrayList<>();

            for (int i = 0; i < 4; i++){
                char al = (char)('a' + i + dis*3 + offset);
                if (ch >= '2' && ch <= '6') each.add(al);
                else if (ch == '7') each.add(al);
                else if (ch == '8') each.add(al);
                else if (ch == '9') each.add(al);

                if (ch != '7' && ch != '9' && i == 2)
                    break;
            }

            alphabet.add(each);
        }

        List<String> ans = new ArrayList<>();
        gen(0, alphabet, new StringBuilder(), ans);

        return ans;
    }

    private void gen(int idx, List<List<Character>> alphabet,
            StringBuilder sb, List<String> ans){

        if (idx == alphabet.size()){
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < alphabet.get(idx).size(); i++){
            sb.append(alphabet.get(idx).get(i));
            gen(idx+1, alphabet, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
