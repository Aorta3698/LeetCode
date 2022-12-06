class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            // char[] ch = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = s.length()-1; i >=0; i--){
                char c = (char)(s.charAt(i) - s.charAt(0) + 'a');
                if (c < 'a') c = (char)(c + 26);
                // ch[i] = c;
                sb.append(c);
            }
            //String key = String.valueOf(ch);
            String key = sb.toString();
            List<String> l = map.getOrDefault(key, new ArrayList());
            l.add(s);
            map.put(key, l);
        }

        return new ArrayList(map.values());
    }
}
