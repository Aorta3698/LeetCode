public class Codec {

    // Encodes a URL to a shortened URL.
    Random random = new Random();
    Map<String, String> map = new HashMap<>();
    int sz = 15;
    public String encode(String longUrl) {
        StringBuilder ans = new StringBuilder("http://tinyurl.com/");
        for (int i = 0; i < sz; i++){
            ans.append((char)('a' + random.nextInt(26)));
        }
        map.put(ans.toString(), longUrl);
        return ans.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
