class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int otherPath = 0, path = 0, s = Math.min(start, destination), m = Math.max(start, destination);
        for (int i = 0; i < distance.length; i++){
            if (i >= s && i < m) path += distance[i];
            else otherPath += distance[i];
        }

        return Math.min(otherPath, path);
    }
}
