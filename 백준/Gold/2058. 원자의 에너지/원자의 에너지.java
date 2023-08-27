import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    int[][] dp;
    int numberOfStatus, numberOfDiff;
    Integer[] status;
    Integer[] diff;
    List<Integer>[] node;

    public Main() throws Exception {
        getInput();
        solve();
        bw.write(sb.toString());
        bw.flush();
    }

    void getInput() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfStatus = Integer.parseInt(st.nextToken());
        numberOfDiff = Integer.parseInt(st.nextToken());
        node = new ArrayList[numberOfStatus];
        status = new Integer[numberOfStatus];
        diff = new Integer[numberOfDiff];
        dp = new int[numberOfStatus][2];
        for (int i = 0; i < numberOfStatus; i++) {
            node[i] = new ArrayList<>();
            status[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < numberOfDiff; i++) {
            diff[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(status);
    }

    <T extends Comparable<? super T>> int lowerBound(T[] arr, int begin, int end, T value) {
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (arr[mid].compareTo(value) < 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        if (begin < arr.length && arr[begin].compareTo(value) < 0) {
            begin++;
        }
        return begin;
    }

    void generateEdge() {
        for (int i = 0; i < status.length; i++) {
            for (int j : diff) {
                int nextIndex = lowerBound(status, 0, status.length, status[i] - j);
                if (nextIndex < status.length && status[nextIndex] == status[i] - j) {
                    node[i].add(nextIndex);
                    node[nextIndex].add(i);
                }
            }
        }
    }

    int dfs(int cur, int prev, int isSelected) {
        if (dp[cur][isSelected] != -1) {
            return dp[cur][isSelected];
        }
        dp[cur][isSelected] = isSelected == 1 ? status[cur] : 0;
        for (int next : node[cur]) {
            if (prev == next) {
                continue;
            }
            if (isSelected == 1) {
                dp[cur][isSelected] += dfs(next, cur, 0);
            } else {
                dp[cur][isSelected] += Math.max(dfs(next, cur, 0), dfs(next, cur, 1));
            }
        }
        return dp[cur][isSelected];
    }

    void solve() {
        generateEdge();
        sb.append(Math.max(dfs(0, -1, 0), dfs(0, -1, 1)));
    }


    public static void main(String[] args) throws Exception {
        new Main();
    }

}
