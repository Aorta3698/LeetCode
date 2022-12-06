class ValidWordAbbr {
    HashMap<String, HashSet<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();

        for (String s : dictionary){
            String key = abbr(s);
            HashSet<String> set = map.getOrDefault(key, new HashSet<>());
            set.add(s);
            map.put(key, set);
        }
    }

    public boolean isUnique(String word) {
        HashSet<String> set = map.get(abbr(word));
        if (set == null || set.contains(word) && set.size() == 1)
            return true;

        return false;
    }

    private String abbr(String s){
        if (s.length() <= 2) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length()-2);
        sb.append(s.charAt(s.length()-1));

        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
