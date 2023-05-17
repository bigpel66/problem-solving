import java.io.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int a = Integer.parseInt(st.nextToken());
    //     int b = Integer.parseInt(st.nextToken());
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     for (int i = 0 ; i < b ; i++) {
    //         for (int j = 0 ; j < a ; j++) {
    //             bw.write('*');
    //         }
    //         bw.newLine();
    //     }
    //     bw.flush();
    // }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        IntStream.range(0, b).forEach(n -> sb.append(new String("*").repeat(a)).append("\n"));
        System.out.print(sb.toString());
    }
}