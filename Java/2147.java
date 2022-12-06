class Solution {
    public int numberOfWays(String corridor) {
        int plants = 0, seats = 0, M = (int)1e9+7;
        long ans=1;
        for (char ch : corridor.toCharArray()){
            if (ch == 'S'){
                seats++;
            }
        }
        if (seats==0||seats%2==1){
            return 0;
        }
        seats=0;
        for (char ch : corridor.toCharArray()){
            if (ch == 'S'){
                if (seats==2){
                    ans*=(plants+1);
                    ans%=M;
                    seats=0;
                }
                seats++;
                plants=0;
            }else{
                plants++;
            }
        }
        return (int)ans;
    }
}
