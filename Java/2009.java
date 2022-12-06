class Solution {
    public int minOperations(int[] A) {
        Arrays.sort(A);
        int width = A.length, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < A.length; i++){
            map.merge(A[i], 1, Integer::sum);
            while(A[i]-A[j]+1>width){
                if (map.merge(A[j], -1, Integer::sum) == 0){
                    map.remove(A[j]);
                }
                j++;
            }
            max = Math.max(max, map.size());
        }
        return width - max;
    }
}
