import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger bi = new BigInteger(a);
        bi = bi.add(new BigInteger(b));
        return bi.toString();
    }
}