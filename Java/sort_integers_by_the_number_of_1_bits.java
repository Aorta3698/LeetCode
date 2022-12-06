class Solution {
    public int[] sortByBits(int[] arr) {
        Comparator<Integer> cmp = (a, b) -> {
            int diff = getBinary(a) - getBinary(b);
            if (diff == 0) return a - b;
            else return diff;
        };

        List<Integer> tmp = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(tmp, cmp);
        return tmp.stream().mapToInt(o -> o).toArray();
    }

    private static int getBinary(int n){
        int count = 0;
        while(n > 0){
            count += (n & 1);
            n >>= 1;
        }

        return count;
    }
}
