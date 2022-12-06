https://leetcode.com/problems/text-justification/discuss/2108332/Java-Concise-Solution
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length;){
            int sum = 0, j = i;
            while(j < words.length && sum + words[j].length() <= maxWidth){
                sum += words[j].length()+1;
                j++;
            }
            int numOfGaps = j - i - 1;
            int totalSpace = maxWidth - (sum - 1 - numOfGaps);
            int giveSpace = numOfGaps == 0? 0 : totalSpace/numOfGaps;
            int extraSpace = numOfGaps == 0? 0 : totalSpace % numOfGaps;
            StringBuilder sb = new StringBuilder();
            for (; i < j; i++){
                int give = j == words.length? 1 : giveSpace + (--extraSpace >= 0? 1 : 0);
                sb.append(words[i]);
                if (i < j - 1){
                    sb.append(" ".repeat(give));
                }
            }
            sb.append(" ".repeat(maxWidth - sb.length()));
            ans.add(sb.toString());
        }
        return ans;
    }
}
