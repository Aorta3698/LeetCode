class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0, cnt = 0,j=1; i < s.length(); i++){
            cnt += s.charAt(i) == '1'? 1 : -1;
            if (cnt == 0){
                list.add("1"+makeLargestSpecial(s.substring(j, i))+"0");
                j=i+2;
            }
        }
        list.sort(Comparator.reverseOrder());
        return String.join("", list);
    }
}
