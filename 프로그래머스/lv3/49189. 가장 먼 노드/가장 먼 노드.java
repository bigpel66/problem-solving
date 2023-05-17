import java.util.*;

class Solution {
     static public class Node implements Comparable<Node> {

        public int value;

        public int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }

    }

    public int solution(int n, int[][] edge) {
        int[] distance = generateDistance(n);
        List<Integer>[] matrix = generateMatrix(n, edge);
        boolean[] isVisited = new boolean[n + 1];
        dijkstra(1, isVisited, distance, matrix);
        return getCountOfFarthestDistance(1, distance);
    }

    static public int[] generateDistance(int n) {
        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        return distance;
    }

    static public List<Integer>[] generateMatrix(int n, int[][] edge) {
        List<Integer>[] matrix = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            matrix[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            matrix[node1].add(node2);
            matrix[node2].add(node1);
        }
        return matrix;
    }

    static public void dijkstra(int point, boolean[] isVisited, int[] distance, List<Integer>[] matrix) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(point, 0));
        distance[point] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            isVisited[node.value] = true;
            for (int destination : matrix[node.value]) {
                if (isVisited[destination]) {
                    continue;
                }
                if (distance[destination] > distance[node.value] + 1) {
                    distance[destination] = distance[node.value] + 1;
                    pq.offer(new Node(destination, distance[destination]));
                }
            }
        }
    }

    static public int getCountOfFarthestDistance(int point, int[] distance) {
        int count = 0;
        int farthestDistance = getFarthestDistance(point, distance);
        for (int i = 1; i < distance.length; i++) {
            if (i == point) {
                continue;
            }
            if (farthestDistance == distance[i]) {
                count++;
            }
        }
        return count;
    }

    static public int getFarthestDistance(int point, int[] distance) {
        int value = 0;
        for (int i = 1; i < distance.length; i++) {
            if (i == point) {
                continue;
            }
            value = Math.max(value, distance[i]);
        }
        return value;
    }
}