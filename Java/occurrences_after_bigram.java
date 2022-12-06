class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] t = text.split(" ");
        for (int i = 2; i < t.length; i++)
            if (t[i - 1].equals(second) && t[i - 2].equals(first))
                ans.add(t[i]);


        return ans.toArray(new String[0]);
    }
}
