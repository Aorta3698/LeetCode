class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]+nums1[o[0]]));
        for (int n : nums2){
            minheap.offer(new int[]{0, n});
        }
        while(--k >= 0 && !minheap.isEmpty()){
            int[] cur = minheap.poll();
            ans.add(List.of(nums1[cur[0]], cur[1]));
            if (++cur[0] < nums1.length){
                minheap.offer(cur);
            }
        }
        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         Set<Long> seen = new HashSet<>();
//         PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> nums1[o[0]] + nums2[o[1]]));
//         minheap.offer(new int[]{0, 0});
//         List<List<Integer>> ans = new ArrayList<>();

//         while(--k >= 0 && !minheap.isEmpty()){
//             int x = minheap.peek()[0];
//             int y = minheap.poll()[1];
//             if (x + 1 < nums1.length && seen.add(id(x + 1, y))){
//                 minheap.offer(new int[]{x + 1, y});
//             }
//             if (y + 1 < nums2.length && seen.add(id(x, y + 1))){
//                 minheap.offer(new int[]{x, y + 1});
//             }
//             ans.add(List.of(nums1[x], nums2[y]));
//         }

//         return ans;
//     }

//     private long id(int x, int y){
//         return 100001L * x + y;
//     }
// }
