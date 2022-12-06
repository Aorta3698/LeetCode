class Solution {
    public String[] getFolderNames(String[] names) {
        int n = names.length, idx = 0;
        String[] ans = new String[n];
        Map<String, Set<Integer>> map = new HashMap<>();
        Map<String, Integer> curMap = new HashMap<>();
        for (String s : names){
            int id = getId(s);
            if (id != -1) {
                map.computeIfAbsent(s.substring(0, s.lastIndexOf("(")), o -> new HashSet<>()).add(id);
            }

            if (!map.containsKey(s) || !map.get(s).contains(0)){
                ans[idx++] = s;
                map.computeIfAbsent(s, o -> new HashSet<>()).add(0);
                curMap.put(s, 0);
                continue;
            }

            if (map.containsKey(s)){
                StringBuilder sb = new StringBuilder(s);
                sb.append('(');
                id = curMap.get(s) + 1;
                while(map.get(s).contains(id)) id++;
                curMap.put(s, id);
                sb.append(id);
                sb.append(')');
                ans[idx] = sb.toString();
                map.computeIfAbsent(ans[idx], o -> new HashSet<>()).add(0);
                curMap.putIfAbsent(ans[idx++], 0);
            }
        }

        return ans;
    }

    private int getId(String s){
        if (s.charAt(s.length() - 1) != ')') return -1;

        int id = 0;
        for (int i = s.length() - 2; i >= 0; i--){
            if (s.charAt(i) == '(') return id == 0? -1 : id;
            if (!Character.isDigit(s.charAt(i))) return -1;
            id *= 10;
            id += (s.charAt(i) - '0');
        }

        return -1;
    }
}
