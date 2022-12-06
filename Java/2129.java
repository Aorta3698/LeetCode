class Solution {
    public String capitalizeTitle(String title) {
        String[] data = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : data){
            int add = s.length() >= 3? 1 : 0;
            for (char ch : s.toCharArray()){
                if (--add == 0)
                    sb.append(Character.toUpperCase(ch));
                else
                    sb.append(Character.toLowerCase(ch));
            }
            sb.append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
