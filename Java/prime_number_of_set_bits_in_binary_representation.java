class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> prime = new HashSet<>(Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23));
        int ans = 0;
        for (int i = left; i <= right; i++){
            int count = 0, copy = i;
            while(copy > 0){
                copy &= copy - 1;
                count++;
            }
            if (prime.contains(count)) ans++;
        }

        return ans;
    }
}
