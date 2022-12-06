class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        String key = s1+s2;
        if (map.containsKey(key)){
            return map.get(key);
        }
        if (s1.length()>1&&ok(s1,s2)){
            for (int i = 1; i < s1.length(); i++){
                String a = s1.substring(i), b = s1.substring(0, i);
                String x = s2.substring(i), y = s2.substring(0, i);
                String n = s2.substring(s1.length()-i), m=s2.substring(0, s1.length()-i);
                if (isScramble(a, x)&&isScramble(b, y)||isScramble(a, m)&&isScramble(b, n)){
                    map.put(key,true);
                    return true;
                }
            }
        }
        boolean res=s1.equals(s2);
        map.put(key,res);
        return res;
    }

    private boolean ok(String a, String b){
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (count[i]>0){
                return false;
            }
        }
        return true;
    }
}
