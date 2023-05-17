class Solution {
    public int solution(String s) {
        // int count = 0;
        // while (!s.isBlank()) {
        //     StringBuilder c1 = new StringBuilder();
        //     StringBuilder c2 = new StringBuilder();
        //     Character first = s.charAt(0);
        //     for (int i = 0 ; i < s.length() ; i++) {
        //         if (first == s.charAt(i)) {
        //             c1.append(s.charAt(i));
        //         } else {
        //             c2.append(s.charAt(i));
        //         }
        //         if (i == s.length() - 1 || c1.length() == c2.length()) {
        //             count++;
        //             s = s.substring(i + 1);
        //             break;
        //         }
        //     }            
        // }
        // return count;
        
        int count = 0;
        char first = s.charAt(0);
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (first == s.charAt(i)) {
                v1++;
            } else {
                v2++;
            }
            if (i == s.length() - 1 || v1 == v2) {
                count++;
                if (i != s.length() - 1) {
                    first = s.charAt(i + 1);
                    v1 = 0;
                    v2 = 0;
                }
            }
        }
        return count;
    }
}