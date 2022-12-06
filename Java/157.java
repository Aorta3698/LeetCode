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
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int cnt = read4(tmp);
        Queue<Character> queue = new ArrayDeque<>();

        while(cnt != 0 && queue.size() < n) {
            for (int i = 0; i < cnt; i++)
                queue.offer(tmp[i]);
            tmp = new char[4];
            cnt = read4(tmp);
        }

        int sz = Math.min(queue.size(), n);
        for (int i = 0; i < sz; i++)
            buf[i] = queue.poll();

        return sz;
    }
}
