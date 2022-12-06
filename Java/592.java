class Solution {
    public String fractionAddition(String expression) {
        List<long[]> nums = new ArrayList<>();
        int turn = 0;

        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '/')
                continue;
            int j = i + 1;
            while(j < expression.length() && Character.isDigit(expression.charAt(j))){
                ++j;
            }
            int n = Integer.parseInt(expression.substring(i, j));
            if (turn == 0){
                nums.add(new long[2]);
            }
            nums.get(nums.size() - 1)[turn] = n;
            turn = 1 - turn;
            i = j - 1;
        }

        Queue<Long> lo = new ArrayDeque<>();
        for (long[] n : nums){
            lo.add(n[1]);
        }

        while(lo.size() > 1){
            long a = lo.poll(), b = lo.poll();
            lo.offer(a * b / gcd(a, b));
        }

        long lcm = lo.poll(), top = 0;
        for (long[] n : nums){
            top += n[0] * (lcm / n[1]);
        }

        long common = gcd(Math.abs(top), Math.abs(lcm));
        top /= common;
        lcm /= common;

        return top + "/" + lcm;
    }

    private long gcd(long a, long b){
        return a == 0? b : gcd(b % a, a);
    }

}
