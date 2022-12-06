class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles >= numExchange){
            int ref = numBottles / numExchange;
            int empty = numBottles % numExchange;
            ans += ref;
            numBottles = ref + empty;
        }

        return ans;
    }
}
