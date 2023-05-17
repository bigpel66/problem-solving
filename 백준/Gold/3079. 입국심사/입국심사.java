import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] customs = new int[N];
        for (int i = 0; i < N; i++) {
            customs[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = 1_000_000_000_000_000_000L;

        while (start <= end) {
            long mid = (start + end) / 2;
            long temp = 0;
            for (int num: customs) {
                temp += (mid / num);
                if (temp >= M) break;
            }
            if (temp >= M) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

}