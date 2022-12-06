https://leetcode.com/problems/word-abbreviation/discuss/2348361/BruteForce-with-Trie-or-Java
class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        List<String> ans = new ArrayList<>();
        Trie root = new Trie();
        String[] abbr = new String[words.size()];
        for (int i = 0; i < words.size(); i++){ // what is it supposed to be if alone?
            String s = words.get(i);
            abbr[i]= s.length()<3?s:""+s.charAt(0)+(s.length()-2)+s.charAt(s.length()-1);
        }
        for (int i = 0; i < words.size(); i++){
            Trie cur = root;
            for (char ch : words.get(i).toCharArray()){
                if (cur.nodes[ch-'a']==null){
                    cur.nodes[ch-'a']=new Trie();
                }
                cur=cur.nodes[ch-'a'];
                cur.map.merge(abbr[i], 1, Integer::sum); // insert the alone version into the trie map
            }
        }
        for (int i = 0; i < words.size(); i++){
            String s = words.get(i);
            Trie cur = root;
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()){
                cur = cur.nodes[ch-'a'];
                sb.append(ch);
                int mid = s.length() - sb.length() - 1;
                if (cur.map.get(abbr[i]) == 1 && mid > 1){ // it is only unique when there is only it alone in the map & mid > 1
                    sb.append(mid);
		    sb.append(s.charAt(s.length()-1));
                    break;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    private class Trie{
        Trie[] nodes = new Trie[26];
        Map<String, Integer> map = new HashMap<>();
        Trie(){}
    }
}
