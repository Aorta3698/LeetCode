https://leetcode.com/problems/find-common-characters/discuss/?currentPage=1&orderBy=newest_to_oldest&query=
```
class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int[][] count = new int[n][26]; // a - z --> 26 characters
        for (int i = 0; i < n; i++)
            for (char ch : words[i].toCharArray())
                count[i][ch - 'a']++; //store the count

        for (int i = 0; i < 26; i++){ //loop through all possible characters
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) //update min according to the number of apparances in each string
                min = Math.min(count[j][i], min);
            for (int j = 0; j < min; j++) //add "min" times
                ans.add(String.valueOf((char)('a' + i)));
        }

        return ans;
    }
}
```

class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++)
            for (char ch : words[i].toCharArray())
                count[i][ch - 'a']++;

        for (int i = 0; i < 26; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
                min = Math.min(count[j][i], min);
            for (int j = 0; j < min; j++)
                ans.add(String.valueOf((char)('a' + i)));
        }

        return ans;
    }
}
