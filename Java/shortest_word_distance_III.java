class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        boolean same = word1.equals(word2);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++){
            if (!same && wordsDict[i].equals(word2))
                b.add(i);
            if (wordsDict[i].equals(word1))
                a.add(i);
        }

        if (same){
            int prev = Integer.MAX_VALUE; //can't be MIN_VALUE because Math.abs() can't convert it.
            for (int i : a){
                min = Math.min(min, Math.abs(i - prev));
                prev = i;
            }
        }else{
            int x = 0;
            int y = 0;
            int dis = 0;
            while(x < a.size() && y < b.size()){
                dis = a.get(x) - b.get(y);
                min = Math.min(min, Math.abs(dis));
                if (dis > 0) y++;
                if (dis < 0) x++;
            }
        }

        return min;
    }
}
