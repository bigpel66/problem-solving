class Solution {
//     public int solution(String A, String B) {
//         int answer = 0;
//         if (A.equals(B)) {
//             return answer;
//         }
//         for (int i = 0 ; i < A.length() - 1 ; i++) {
//             A = rShift(A);
//             answer++;
//             if (A.equals(B)) {
//                 return answer;
//             }
//         }
//         return -1;
//     }
    
//     public String rShift(String str) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(str.charAt(str.length() - 1));
//         for (int i = 0 ; i < str.length() - 1 ; i++) {
//             sb.append(str.charAt(i));
//         }
//         return sb.toString();
//     }
    
    public int solution(String A, String B) {
        return (B + B).indexOf(A);
    }
}