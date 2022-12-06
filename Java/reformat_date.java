class Solution {
    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) map.put(months[i - 1], String.format("%02d", i));

        String[] parts = date.split(" ");
        StringBuilder sb = new StringBuilder(parts[2]);
        sb.append('-');
        sb.append(map.get(parts[1]));
        sb.append('-');
        sb.append(String.format("%02d", Integer.parseInt(parts[0].substring(0, parts[0].length() - 2))));

        return sb.toString();
    }
}
