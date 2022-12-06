class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int target = -1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++){
            if (ok(start, bank[i])){
                map.computeIfAbsent(-1, o -> new ArrayList<>()).add(i);
            }
            if (target == -1 && end.equals(bank[i])){
                target = i;
            }
        }

        if (target == -1){
            return -1;
        }

        for (int i = 0; i < bank.length; i++){
            for (int j = i + 1; j < bank.length; j++){
                if (ok(bank[i], bank[j])){
                    map.computeIfAbsent(i, o -> new ArrayList<>()).add(j);
                    map.computeIfAbsent(j, o -> new ArrayList<>()).add(i);
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>(List.of(-1));
        boolean[] seen = new boolean[bank.length + 1];
        int step = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.poll();
                if (seen[cur + 1]){
                    continue;
                }
                if (cur == target){
                    return step;
                }

                seen[cur + 1] = true;
                for (int next : map.getOrDefault(cur, Collections.emptyList())){
                    queue.offer(next);
                }
            }
            step++;
        }

        return -1;
    }

    private boolean ok(String one, String two){
        int d = 0;
        for (int i = 0; i < 8 && d <= 1; i++){
            if (one.charAt(i) != two.charAt(i)){
                d++;
            }
        }
        return d <= 1;
    }
}
