class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        int idx = ans.length - 1;
        List<String> letter = new ArrayList<>();
        for (int i = logs.length - 1; i >= 0; i--){
            if (Character.isDigit(logs[i].charAt(logs[i].length() - 1)))
                ans[idx--] = logs[i];
            else
                letter.add(logs[i]);
        }

        Comparator<String> cmp = (a, b) -> {
            String contentA = a.substring(a.indexOf(" ") + 1, a.length());
            String contentB = b.substring(b.indexOf(" ") + 1, b.length());
            String keyA = a.substring(0, a.indexOf(" "));
            String keyB = b.substring(0, b.indexOf(" "));

            return contentA.equals(contentB)? keyA.compareTo(keyB) : contentA.compareTo(contentB);
        };

        Collections.sort(letter, cmp);
        for (int i = 0; i < letter.size(); i++)
            ans[i] = letter.get(i);

        return ans;
    }
}
