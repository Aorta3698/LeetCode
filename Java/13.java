class Solution {
    public int romanToInt(String s) {
        int ans = 0,n=s.length();
        for (int i = 0; i < n; i++){
            int now = ans;
            if (i<n-1){
                switch(s.substring(i,i+2)){
                    case "IV" -> ans+=4;
                    case "IX" -> ans+=9;
                    case "XL" -> ans+=40;
                    case "XC" -> ans+=90;
                    case "CD" -> ans+=400;
                    case "CM" -> ans+=900;
                    default -> {}
                };
                if (now != ans){
                    i++;
                    continue;
                }
            }
            switch(s.charAt(i)){
                case 'I' -> ans++;
                case 'V' -> ans+=5;
                case 'X' -> ans+=10;
                case 'L' -> ans+=50;
                case 'C' -> ans+=100;
                case 'D' -> ans+=500;
                case 'M' -> ans+=1000;
                default -> {}
            };
        }
        return ans;
    }
}
