class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Iterator<Integer>> queue = new ArrayDeque<>();
        int pos = 0;
        do{
            if (pos < nums.size()) queue.offerFirst(nums.get(pos).iterator());
            int sz = queue.size();
            while(--sz >= 0){
                Iterator<Integer> cur = queue.poll();
                ans.add(cur.next());
                if (cur.hasNext()){
                    queue.offer(cur);
                }
            }
            pos++;
        }while(!queue.isEmpty() || pos < nums.size());

        return ans.stream().mapToInt(o -> o).toArray();
    }
}
