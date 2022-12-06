public class ZigzagIterator {

    private int[] arr;
    private int count;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        arr = new int[v1.size() + v2.size()];
        for (int i = 0; i < Math.max(v1.size(), v2.size()); i++){
            if (v1.size() > i) arr[count++] = v1.get(i);
            if (v2.size() > i) arr[count++] = v2.get(i);
        }

        count = 0;
    }

    public int next() {
        return arr[count++];
    }

    public boolean hasNext() {
        return count < arr.length;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
