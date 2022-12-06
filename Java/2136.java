class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Flower[] all = new Flower[plantTime.length];
        for (int i = 0; i < all.length; i++){
            all[i] = new Flower(growTime[i], plantTime[i]);
        }
        Arrays.sort(all, Comparator.comparingInt(o -> -o.grow));
        int ans = 0, cur = -1;
        for (Flower f : all){
            cur += f.plant;
            ans = Math.max(ans, cur + f.grow + 1);
        }
        return ans;
    }

    private class Flower {
        int grow;
        int plant;
        Flower (int grow, int plant){
            this.grow = grow;
            this.plant = plant;
        }
    }
}
