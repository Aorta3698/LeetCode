class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int swapIdx = len-2;
        while(swapIdx >= 0 && s.charAt(swapIdx) >= s.charAt(swapIdx+1))
            swapIdx--;

        if (swapIdx < 0)
            return -1;

        int idx = len - 1;
        while(s.charAt(idx) <= s.charAt(swapIdx))
            idx--;

        s = swap(s, swapIdx, idx);
        s = reverse(s, swapIdx + 1);
        try{
            return Integer.parseInt(s);
        }catch(Exception e){
            return -1;
        }
    }

    private String swap(String s, int x, int y){
        if (y < x) return swap(s, y, x);
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, x));
        sb.append(s.charAt(y));
        sb.append(s.substring(x + 1, y));
        sb.append(s.charAt(x));
        sb.append(s.substring(y+1));
        return sb.toString();
    }

    private String reverse(String s, int sIdx){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
            if (i == sIdx) sb.reverse();
        }

        return sb.reverse().toString();
    }
}
