class Solution {
    public String toHex(int num) {
        long n = num < 0? Math.abs((long)2*Integer.MIN_VALUE) + num : num;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 6; i++) map.put(i + 10, (char)('a' + i));
        for (int i = 0; i < 10;i++) map.put(i, (char)('0' + i));

        long base = 1;
        while(base * 16 <= n) base *= 16;

        while(base > 0){
            long d = n / base;
            n -= d * base;
            base /= 16;
            sb.append(map.get((int)d));
        }

        return sb.toString();
    }
}
