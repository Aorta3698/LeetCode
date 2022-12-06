class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int N = 200000;
        int[] count = new int[2*N+1];
        for (int n : Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(o -> Math.abs(o))).toArray(Integer[]::new)){
            if (count[n+N]>0){
                count[n+N]--;
                continue;
            }
            count[2*n+N]++;
        }
        return Arrays.stream(count).sum() == 0;
    }
}
