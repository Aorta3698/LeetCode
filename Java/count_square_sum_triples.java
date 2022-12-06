class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for (int i = n; i >= 0; i--)
            for (int j = 0; j < i; j++)
                for (int w = 0; w < j; w++)
                    if (w*w + j*j == i*i)
                        ans++;

        return ans * 2;
    }
}
