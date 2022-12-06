class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        Comparator<String> comp = (a, b) -> {
            return map.get(a) == map.get(b)?
                b.compareTo(a) : map.get(a) - map.get(b);
        };

        // Comparator<Map.Entry<String, Integer>> comp
        //     = Comparator.comparingInt(Map.Entry<String, Integer>::getValue)
        //     .reversed()
        //     .thenComparing(Map.Entry::getKey);
        // comp = comp.reversed();

        // PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(comp);
        PriorityQueue<String> queue = new PriorityQueue(comp);

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (String word : map.keySet()){
            queue.offer(word);
            if (queue.size() > k)
                queue.poll();
        }

        // for (Map.Entry<String, Integer> entry : map.entrySet()){
        //     queue.offer(entry);
        //     if (queue.size() > k)
        //         queue.poll();
        // }

        LinkedList<String> ans = new LinkedList<>();
        while(k-- > 0)
            ans.addFirst(queue.poll());

        return ans;
    }
}
