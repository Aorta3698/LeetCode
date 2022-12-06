class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++)
            if (connected(beginWord, wordList.get(i)))
                map.computeIfAbsent(0, o -> new ArrayList<>()).add(i + 1);

        int target = -1;
        for (int i = 0; i < wordList.size(); i++){
            if (wordList.get(i).equals(endWord)) target = i + 1;
            for (int j = i + 1; j < wordList.size(); j++){
                if (connected(wordList.get(i), wordList.get(j))){
                    map.computeIfAbsent(i + 1, o -> new ArrayList<>()).add(j + 1);
                    map.computeIfAbsent(j + 1, o -> new ArrayList<>()).add(i + 1);
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>(List.of(0));
        boolean[] seen = new boolean[wordList.size() + 1];
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            while(--size >= 0){
                int cur = queue.poll();
                if (seen[cur]) continue;
                if (cur == target) return step;
                seen[cur] = true;

                for (int next : map.getOrDefault(cur, Collections.emptyList()))
                    queue.offer(next);
            }
        }

        return 0;
    }

    private static boolean connected(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i) && ++count == 2)
                return false;
        return true;
    }
}
