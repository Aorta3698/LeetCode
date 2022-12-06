class Vector2D {

    List<Integer> data;
    Iterator<Integer> iter;
    public Vector2D(int[][] vec) {
        data = new ArrayList<>();
        for (int[] v : vec)
            for (int m : v)
                data.add(m);
        iter = data.iterator();
    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
