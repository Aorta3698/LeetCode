class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10001], fac = new int[10001];
        int n = deck.length, uni = 0;
        for (int d : deck)
            if (++count[d] == 1)
                ++uni;

        for (int i = 0; i < 10001; i++){
            if (count[i] == 0) continue;
            if (count[i] == 1) return false;
            if (factor(count[i], fac, uni)) return true;
        }

        return false;
    }

    private static boolean factor(int n, int[] fac, int uni){
        if (++fac[n] == uni) return true;
        for (int i = 2; i * i <= n; i++){
            if (n % i != 0) continue;
            if (n / i != i && ++fac[n / i] == uni) return true;
            if (++fac[i] == uni) return true;
        }

        return false;
    }
}
