class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) broken.add(ch);
        int ans = 0;
        for (String t : arr){
            int add = 1;
            for (char ch : t.toCharArray())
                if (broken.contains(ch) && --add == 0)
                    break;
            ans += add;
        }

        return ans;
    }
}
