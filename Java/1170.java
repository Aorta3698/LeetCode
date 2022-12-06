class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] count = new int[words.length];
        int i = 0;
        for (String w : words){
            count[i++] = get(w);
        }

        int[] data = new int[11];
        for (int n : count){
            data[n]++;
        }

        for (i = 1; i <= 10; i++){
            data[i] += data[i - 1];
        }

        i = 0;
        for (String q : queries){
            ans[i++] = words.length - data[get(q)];
        }

        return ans;
    }

    private int get(String s){
        char cur = 'z';
        int cnt = 0;
        for (char ch : s.toCharArray()){
            if (ch < cur){
                cur = ch;
                cnt = 0;
            }
            if (ch == cur){
                cnt++;
            }
        }
        return cnt;
    }
}
