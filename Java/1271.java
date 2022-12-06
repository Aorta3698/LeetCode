class Solution {
    public String toHexspeak(String num) {
        return hexify(Long.parseLong(num));
    }

    private static String hexify(long n){
        Map<Long, Character> map = new HashMap<>(Map.of(0L, 'O', 1L, 'I'));
        for (int i = 0; i < 6; i++) map.put(i + 10L, (char)('A' + i));
        StringBuilder sb = new StringBuilder();

        long cur = 1;
        while(cur*16 < n) cur *= 16;
        while(cur > 0){
            long d = n / cur;
            n -= d * cur;
            cur /= 16;

            if (!map.containsKey(d)){
                sb.setLength(0);
                sb.append("ERROR");
                return sb.toString();
            }

            sb.append(map.get(d));
        }

        return sb.toString();
    }
}
