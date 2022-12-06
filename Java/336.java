https://leetcode.com/problems/palindrome-pairs/discuss/2247658/Java-or-Short-solution-O(nkk)

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++){
            Trie cur = root;
            for (int j = words[i].length()-1; j>=0;--j){
                int ch = words[i].charAt(j)-'a';
                if (cur.nodes[ch]==null){
                    cur.nodes[ch]=new Trie();
                }
                if (ok(j+1, words[i].length()-1, words[i])){
                    cur.suffix.add(i);
                }
                cur=cur.nodes[ch];
            }
            cur.idx=i;
        }
        for (int i = 0; i < words.length; i++){
            Trie cur = root;
            for (int j=0;j<words[i].length()&&cur!=null;++j){
                if (cur.idx!=-1&&cur.idx!=i&&ok(j+1,words[i].length()-1,words[i])){
                    ans.add(List.of(i, cur.idx));
                }
                cur=cur.nodes[words[i].charAt(j)-'a'];
            }
            for (int idx : cur.suffix){
                if (idx!=i){
                    ans.add(List.of(i, cur.idx));
                }
            }
        }
        return ans;
    }

    private boolean ok(int i, int j, String s){
        while(i<j&&s.charAt(i)==s.charAt(j)){
            ++i;
            --j;
        }
        return i>=j;
    }

    private class Trie {
        List<Integer> suffix = new ArrayList<>();
        Trie[] nodes = new Trie[26];
        int idx=-1;
        Trie(){}
    }
}


// TLE O(nkk) but short & correct
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Integer[] idx = IntStream.range(0, words.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> words[o].length()));
        for (int i = 0; i < idx.length; i++){
            String s= words[idx[i]];
            int n =s.length();
            for (int j=0;j<=n;j++){
                String a = reverse(s.substring(n-j));
                String b = reverse(s.substring(0,j));
                if (map.containsKey(a)&&ok(a+s)){
                    ans.add(List.of(map.get(a), idx[i]));
                }
                if (map.containsKey(b)&&ok(s+b)){
                    ans.add(List.of(idx[i], map.get(b)));
                }
            }
            map.put(s, idx[i]);
        }

        return ans;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    private boolean ok(String s){
        return reverse(s).equals(s);
    }
}


// non-TLE (nkk)
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Integer[] idx = IntStream.range(0, words.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> words[o].length()));
        for (int i = 0; i < idx.length; i++){
            String s= words[idx[i]];
            int n =s.length();
            for (int j=0;j<=n;j++){
                String a = reverse(s.substring(n-j));
                String b = reverse(s.substring(0,j));
                if (map.containsKey(a)&&ok(a,s)){
                    ans.add(List.of(map.get(a), idx[i]));
                }
                if (map.containsKey(b)&&ok(s,b)){
                    ans.add(List.of(idx[i], map.get(b)));
                }
            }
            map.put(s, idx[i]);
        }

        return ans;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    private boolean ok(String a, String b){
        int i = 0, j = b.length()-1;
        if (a.isEmpty()){
            a=b;
        }
        if (b.isEmpty()){
            b=a;
            j=a.length()-1;
        }
        for (int k =0;k<(a.length()+b.length())/2;k++){
            if (a.charAt(i)!=b.charAt(j)){
                return false;
            }
            if (++i==a.length()){
                i=0;
                a=b;
            }
            if (--j==-1){
                j=a.length()-1;
                b=a;
            }
        }
        return true;
    }
}
