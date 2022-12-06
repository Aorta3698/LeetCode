class Solution {
    String NO = "Neither";
    String FOUR = "IPv4";
    String SIX = "IPv6";

    public String validIPAddress(String queryIP) {
        boolean f = queryIP.contains(".");
        String[] ip = queryIP.split(f? "\\." : ":", -1);
        return f?
            ipv4(ip) : ipv6(ip);
    }

    private String ipv4(String[] ip){
        if (ip.length != 4)
            return NO;
        for (String s : ip){
            int cur = parse(s);
            if (s.length() == 0 || cur < 0 || cur > 255 || s.charAt(0) == '0' && s.length() > 1)
                return NO;
        }
        return FOUR;
    }

    private String ipv6(String[] ip){
        if (ip.length != 8)
            return NO;
        for (String s : ip){
            for (char ch : s.toCharArray()){
                if (ch >= '0' && ch <= '9')
                    continue;
                if (ch >= 'a' && ch <= 'f')
                    continue;
                if (ch >= 'A' && ch <= 'F')
                    continue;
                return NO;
            }
            if (s.length() == 0 || s.length() > 4)
                return NO;
        }
        return SIX;
    }

    private int parse(String s){
        int ans = 0;
        try{
            ans = Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return -1;
        }
        return ans;
    }
}
