import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] costs) {
        int totalCosts = 0;
        int[] parent = new int[n];
        Arrays.sort(costs, Comparator.comparingInt((int[] v) -> v[2]));
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < costs.length; i++) {
            if (!isAlreadyConnected(parent, costs[i][0], costs[i][1])) {
                totalCosts += costs[i][2];
                connectByParent(parent, costs[i][0], costs[i][1]);
            }
        }
        return totalCosts;
    }

    public boolean isAlreadyConnected(int[] parent, int v1, int v2) {
        int parentV1 = getParent(parent, v1);
        int parentV2 = getParent(parent, v2);
        return parentV1 == parentV2;
    }

    public void connectByParent(int[] parent, int v1, int v2) {
        int parentV1 = getParent(parent, v1);
        int parentV2 = getParent(parent, v2);
        if (parentV1 < parentV2) {
            parent[parentV2] = parentV1;
        } else {
            parent[parentV1] = parentV2;
        }
    }

    public int getParent(int[] parent, int v) {
        if (parent[v] == v) {
            return v;
        }
        return getParent(parent, parent[v]);
    }
}