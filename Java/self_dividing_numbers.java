class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <=right; i++){
            int copy = i;
            while(copy > 0){
                int d = copy % 10;
                if (d == 0 || i % d != 0) break;
                copy /= 10;
            }
            if (copy == 0) ans.add(i);
        }

        return ans;
    }
}
