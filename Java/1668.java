class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        do{
            sb.append(word);
            idx = sequence.indexOf(sb.toString(), idx);
        }while(idx != -1);

        return sb.length() / word.length() - 1;
    }
}

// OLD SOLUTION
class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        for (int i = 0; i <= n - m; i++){
            if (sequence.substring(i, i + m).equals(word)){
                int j = i + m;
                while(j < n){
                    if (sequence.charAt(j) != sequence.charAt(j - m))
                        break;
                    j++;
                }
                ans = Math.max((j - i) / m, ans);
            }
        }

        return ans;
    }
}
