import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws Exception {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String stringA = br.readLine();
            String stringB = br.readLine();
            int[] alpha = new int[26];
            for (int i = 0; i < stringA.length(); ++i) {
                ++alpha[stringA.charAt(i) - 'A'];
                --alpha[stringB.charAt(i) - 'A'];
            }
            for (int i = 0; i < 26; i++) {
                if (alpha[i] != 0) {
                    System.out.println(-1);
                    return;
                }
            }
            int count = 0;
            int offset = stringA.length() - 1;
            int i = stringB.length() - 1;
            for (; offset >= 0; --offset) {
                if (stringB.charAt(i) != stringA.charAt(offset)) {
                    count++;
                } else {
                    i--;
                }
            }
            System.out.print(count);
        }
    }
}