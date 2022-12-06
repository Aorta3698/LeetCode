class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>(
                Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C",
                    500, "D", 1000, "M", 4, "IV", 9, "IX", 40, "XL")
                );
        map.put(90,  "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        StringBuilder sb = new StringBuilder();
        int last = map.lastKey();
        while(num > 0){
            while(num >= last){
                num -= last;
                sb.append(map.get(last));
            }
            if (last > 1){
                last = map.floorKey(last - 1);
            }
        }

        return sb.toString();
    }
}
