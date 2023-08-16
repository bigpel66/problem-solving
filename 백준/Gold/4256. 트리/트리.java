import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int numberOfTest;
    int numberOfNode;
    int[] preorder, inorder;

    public Main() throws Exception {
        numberOfTest = Integer.parseInt(br.readLine());
        while (numberOfTest-- > 0) {
            getInput();
            solve(0, 0, numberOfNode);
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private void getInput() throws Exception {
        numberOfNode = Integer.parseInt(br.readLine());
        preorder = new int[numberOfNode + 1];
        inorder = new int[numberOfNode + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfNode; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve(int index, int begin, int end) {
        int preValue = preorder[index];
        for (int i = begin; i < end; i++) {
            if (inorder[i] == preValue) {
                solve(index + 1, begin, i);
                solve(index + 1 + i - begin, i + 1, end);
                sb.append(preValue).append(' ');
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}