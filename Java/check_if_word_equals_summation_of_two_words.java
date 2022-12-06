class Solution {
    public boolean isSumEqual(String f, String s, String t) {
        return get(f) + get(s) == get(t);
    }

    private int get(String s){
        int sum = 0, i = 0;
        while(i < s.length()){sum *= 10; sum += s.charAt(i++) - 'a';}
        return sum;
    }
}
