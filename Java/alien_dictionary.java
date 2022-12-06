class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        HashMap<Character, Integer> chToId = new HashMap<>();
        HashMap<Integer, Character> idToCh = new HashMap<>();
        int id = 0;
        for (int i = 0; i < words.length; i++){
            for (char ch : words[i].toCharArray()){
                if (!chToId.containsKey(ch)){
                    chToId.put(ch, id);
                    idToCh.put(id++, ch);
                }
            }

            if (i != words.length - 1){
                String next = words[i+1];
                int len = words[i].length();
                int nLen = next.length();
                int idx = 0;
                char letter = ' ';
                char nLetter = ' ';
                do{
                    letter = words[i].charAt(idx);
                    nLetter = next.charAt(idx);
                    idx++;
                }
                while(letter == nLetter && idx < Math.min(len, nLen));
                if (letter == nLetter){
                    if (nLen < len) return "";
                    continue;
                }
                map.putIfAbsent(letter, new ArrayList<>());
                map.get(letter).add(nLetter);
            }
        }

        int[] ind = new int[chToId.size()];
        for (List<Character> list : map.values())
            for (char v : list)
                ind[chToId.get(v)]++;

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < ind.length; i++)
            if (ind[i] == 0) queue.offer(idToCh.get(i));

        int visited = 0;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            visited++;
            char cur = queue.poll();
            sb.append(cur);
            if (map.get(cur) == null) continue;
            for (char ch : map.get(cur))
                if (--ind[chToId.get(ch)] == 0) queue.offer(ch);
        }

        return visited == chToId.size()? sb.toString() : "";
    }
}
