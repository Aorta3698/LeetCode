class Solution {
    public String arrangeWords(String text) {
        String[] all = text.toLowerCase().split(" ");
        Arrays.sort(all, Comparator.comparingInt(String::length));
        String ans = String.join(" ", all);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }
}
// class Solution {
//     public String arrangeWords(String text) {
//         List<Word> all = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i <= text.length(); i++){
//             if (i == text.length() || text.charAt(i) == ' '){
//                 all.add(new Word(sb.toString(), all.size()));
//                 sb.setLength(0);
//             }else if (i < text.length()){
//                 sb.append(text.charAt(i));
//             }
//         }
//         all.sort((a, b) -> a.w.length() == b.w.length()? a.idx - b.idx : a.w.length() - b.w.length());
//         for (Word s : all){
//             if (s.w.charAt(0) < 'a' || sb.isEmpty()){
//                 sb.append((sb.isEmpty()?
//                             Character.toUpperCase(s.w.charAt(0)) : Character.toLowerCase(s.w.charAt(0)))
//                         + s.w.substring(1));
//             }else{
//                 sb.append(s.w);
//             }
//             sb.append(' ');
//         }
//         sb.setLength(sb.length() - 1);
//         return sb.toString();
//     }

//     private class Word {
//         String w;
//         int idx;
//         Word (String w, int idx){
//             this.w = w;
//             this.idx = idx;
//         }
//     }
// }
