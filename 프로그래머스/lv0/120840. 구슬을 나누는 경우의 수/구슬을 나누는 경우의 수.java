import java.math.BigInteger;
    
class Solution {
//     public BigInteger factorial(int n) {
//         BigInteger bigInt = new BigInteger("1");
//         for (Integer i = 2 ; i <= n ; i++) {
//             bigInt = bigInt.multiply(new BigInteger(i.toString()));
//         }
//         return bigInt;
//     }
    
//     public int solution(int balls, int share) {
//         BigInteger numer = factorial(balls);
//         BigInteger denom = factorial(share).multiply(factorial(balls - share));
//         BigInteger answer = numer.divide(denom);
//         return answer.intValue();
//     }
    
    public long solution(int balls, int share) {
        share = Math.min(balls - share ,share);
        if (share == 0) {
            return 1L;
        }
        long value = solution(balls - 1, share - 1);
        return balls * value / share;
    }
}