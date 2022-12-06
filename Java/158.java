/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int ttl = 0;
    int cur = 0;
    int cnt = 0;
    char[] copy = new char[1000];
    public int read(char[] buf, int n) {
        while(true){
            int got = read4(buf);
            for (int i = 0; i < got; i++){
                copy[i+cur]=buf[i];
            }
            cur += got;
            cnt += got;
            if (got==0){
                break;
            }
        }
        if(cnt!=-1){
            cur=0;
            ttl = cnt;
        }
        cnt = -1;
        int ans = Math.min(n, ttl-cur);
        for (int i = 0; i < ans; i++){
            buf[i]=copy[cur+i];
        }
        cur+=ans;
        return ans;
    }
}
