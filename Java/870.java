https://leetcode.com/problems/advantage-shuffle/discuss/2461117/Java-or-2-Pointers-or-5-lines.
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] a = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(o -> A[o])).mapToInt(o -> o).toArray();
        int[] b = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(o -> B[o])).mapToInt(o -> o).toArray();
        for (int i = 0, j = 0; i < n; j++){
            ans[A[a[j]] > B[b[i]]? b[i++] : b[--n]] = A[a[j]];
        }
        return ans;
    }
}

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++){
            map.merge(nums1[i], 1, Integer::sum);
        }
        for (int i = 0; i < nums2.length; i++){
            Integer ceil = map.higherKey(nums2[i]);
            if (ceil == null){
                ceil = map.firstKey();
            }
            if (map.merge(ceil, -1, Integer::sum) == 0){
                map.remove(ceil);
            }
            ans[i] = ceil;
        }
        return ans;
    }
}
