#include <climits>
#include <cmath>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> road_to_matrix(int N, vector<vector<int>>& road) {
    vector<vector<int>> matrix(N + 1, vector<int>(N + 1, 0));
    for (auto&& r : road) {
        int i = r.at(0);
        int j = r.at(1);
        int cost = r.at(2);
        if (matrix.at(i).at(j) != 0) {
            matrix[i][j] = min(matrix[i][j], cost);    
        } else {
            matrix[i][j] = cost;
        }
        if (matrix.at(j).at(i) != 0) {
            matrix[j][i] = min(matrix[j][i], cost);    
        } else {
            matrix[j][i] = cost;
        }
    }
    return matrix;
}

vector<int> dijkstra(int N, vector<vector<int>>& matrix) {
    queue<int> q;
    vector<int> distances(N + 1, 1'000'000);
    q.push(1);
    distances[1] = 0;
    while (!q.empty()) {
        int point = q.front();
        q.pop();
        vector<int> temp;
        for (int i = 1 ; i <= N ; i++) {
            if (matrix.at(point).at(i) != 0 && distances.at(i) > distances.at(point) + matrix.at(point).at(i)) {
                temp.push_back(i);
            }
        }
        for (auto&& i : temp) {
            distances[i] = min(distances.at(i), distances.at(point) + matrix.at(point).at(i));
            q.push(i);
        }
    }
    return distances;
}

int distance_under_K(vector<int>& distances, int K) {
    int answer = 0;
    for (auto&& i : distances) {
        if (i <= K) {
            answer++;
        }
    }
    return answer;
}

int solution(int N, vector<vector<int> > road, int K) {
    vector<vector<int>>&& matrix = road_to_matrix(N, road);
    vector<int>&& distances = dijkstra(N, matrix);
    return distance_under_K(distances, K);
}