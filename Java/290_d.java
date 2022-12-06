class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] ans = new int[persons.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] f : flowers){
            map.merge(f[0], 1, Integer::sum);
            map.merge(f[1] + 1,-1, Integer::sum);
        }
        Person[] arr = new Person[persons.length];
        for (int i = 0; i < persons.length; i++){
            arr[i] = new Person(i, persons[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.arrive));
        int open = 0, j = 0;
        for (int key : map.keySet()){
            while(key > arr[j].arrive){
                ans[arr[j].idx] = open;
                if (++j == arr.length)
                    return ans;
            }
            open += map.get(key);
        }

        return ans;
    }

    private class Person {
        int idx;
        int arrive;
        Person (int idx, int arrive){
            this.idx = idx;
            this.arrive = arrive;
        }
    }
}
