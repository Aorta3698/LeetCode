class SnakeGame {

    Queue<int[]> food;
    Queue<int[]> past;
    BitSet bit;
    int x, y, n, m;
    public SnakeGame(int width, int height, int[][] food) {
        x = 0; y = 0;
        this.food = new ArrayDeque<>();
        past = new ArrayDeque<>();
        n = width; m = height;
        for (int[] f : food){
            this.food.offer(f);
        }
        past.offer(new int[]{x, y});
        bit = new BitSet();
        bit.set(0);
    }

    public int move(String direction) {
        switch(direction){
            case "U" -> x--;
            case "D" -> x++;
            case "L" -> y--;
            case "R" -> y++;
        };
        if (x < 0 || y < 0 || x == m || y == n)
            return -1;

        if (!food.isEmpty() && x == food.peek()[0] && y == food.peek()[1]){
            food.poll();
        }else{
            bit.clear(id(past.poll()));
        }

        int[] cur = new int[]{x, y};
        if (bit.get(id(cur)))
            return -1;
        past.offer(cur);
        bit.set(id(cur));
        return past.size() - 1;
    }

    private int id(int[] arr){
        return 10001 * arr[0] + arr[1];
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
