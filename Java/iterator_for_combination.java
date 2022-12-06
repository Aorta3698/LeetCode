class CombinationIterator {
    List<String> list;
    Iterator<String> iter;

    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        gen(0, characters, combinationLength, new StringBuilder());
        iter = list.iterator();
    }
    
    public String next() {
        return iter.next();
    }
    
    public boolean hasNext() {
        return iter.hasNext();
    }

    private void gen(int start, String s, int len, StringBuilder sb){
        if (sb.length() == len){
            list.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length(); i++){
            sb.append(s.charAt(i));
            gen(i + 1, s, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
