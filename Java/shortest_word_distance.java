class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDis = 0;
        boolean[] seen = new boolean[wordsDict.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < wordsDict.length; i++)
            if (wordsDict[i].equals(word1)){
                queue.offer(i - 1);
                queue.offer(i + 1);
                seen[i] = true;
            }

        while(!queue.isEmpty()){
            minDis++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int idx = queue.poll();

                if (idx < 0 || idx >= wordsDict.length || seen[idx])
                    continue;

                seen[idx] = true;
                if (wordsDict[idx].equals(word2))
                    return minDis;

                queue.offer(idx + 1);
                queue.offer(idx - 1);
            }
        }

        return 0;
    }
}
