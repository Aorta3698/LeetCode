class ParkingSystem {

    HashMap<Integer, Integer> map;
    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        map.merge(1, big, Integer::sum);
        map.merge(2, medium, Integer::sum);
        map.merge(3, small, Integer::sum);
    }

    public boolean addCar(int carType) {
        return map.merge(carType, -1, Integer::sum) >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
