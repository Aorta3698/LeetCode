class Solution {
    public String splitLoopedString(String[] strs) {
        int target = 'a', n = strs.length;
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder(strs[i]);
            String reverse = sb.reverse().toString();
            if (strs[i].compareTo(reverse) < 0){
                strs[i] = reverse;
            }
            for (char ch : strs[i].toCharArray()){
                target = Math.max(ch, target);
            }
        }

        String ans = "";
        for (int i = 0; i < n; i++){
            if (!strs[i].contains(""+(char)target))
                continue;
            for (String s : new String[]{strs[i], new StringBuilder(strs[i]).reverse().toString()}){
                for (int j = 0; j < s.length(); j++){
                    if (s.charAt(j) != target)
                        continue;
                    StringBuilder cur = new StringBuilder();
                    cur.append(s.substring(j));
                    for (int k = (i + 1) % n; k != i; k = (k + 1) % n){
                        cur.append(strs[k]);
                    }
                    cur.append(s.substring(0, j));
                    if (cur.toString().compareTo(ans) > 0){
                        ans = cur.toString();
                    }
                }
            }
        }

        return ans;
    }
}
