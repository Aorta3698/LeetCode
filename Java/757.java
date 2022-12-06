https://leetcode.com/problems/set-intersection-size-at-least-two/discuss/2417398/Lazy-BitSet-Sol-or-Add-a1-and-a1-1
class Solution {
    public int intersectionSizeTwo(int[][] A) {
        Arrays.sort(A, Comparator.<int[]>comparingInt(o -> o[1]).thenComparingInt(o -> -o[0]));
        List<Integer> list = new ArrayList<>();
        for (int[] a : A){
            list.add(a[0]);
            list.add(a[1]);
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int l : list){ // this is the rank for each number
            map.putIfAbsent(l, map.size());
        }
        BitSet bit = new BitSet();
        for (int[] a : A){
            a[0]=map.get(a[0]); // put the rank in
            a[1]=map.get(a[1]); // put the rank in
            int got = bit.get(a[0],a[1]+1).cardinality();
            if (got <= 0){
                bit.set(a[1]-1);
            }
            if (got <= 1){
                bit.set(a[1]);
            }
        }
        return bit.cardinality();
    }
}
