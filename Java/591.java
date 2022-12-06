class Solution {
    String CDATA_START = "<![CDATA[";
    String CDATA_END = "]]>";
    public boolean isValid(String code) {
        boolean empty = true;
        Deque<String> tag = new ArrayDeque<>();
        for (int i = 0; i < code.length(); i++){
            if (code.charAt(i) == '<'){
                if (code.startsWith(CDATA_START, i)){
                    int end = code.indexOf(CDATA_END, i+CDATA_START.length());
                    if (end == -1 || tag.isEmpty()){
                        return false;
                    }
                    i=end+CDATA_END.length()-1;
                }else{
                    int end = code.indexOf(">", i);
                    if (end == -1){
                        return false;
                    }
                    if (code.charAt(i+1)=='/'){
                        String endTag = code.substring(i+2, end);
                        if (badTag(endTag) || tag.isEmpty() || !tag.peek().equals(endTag)){
                            return false;
                        }
                        tag.pop();
                    }else{
                        String stTag = code.substring(i+1, end);
                        if (badTag(stTag) || !empty && tag.isEmpty()){
                            return false;
                        }
                        empty = false;
                        tag.push(stTag);
                    }
                    i = end;
                }
            }else if (tag.isEmpty()){
                return false;
            }
        }
        return tag.isEmpty();
    }

    private boolean badTag(String tag){
        return tag.length()==0||tag.length()>=10||tag.chars().anyMatch(Character::isLowerCase)||!tag.chars().allMatch(Character::isLetter);
    }
}
