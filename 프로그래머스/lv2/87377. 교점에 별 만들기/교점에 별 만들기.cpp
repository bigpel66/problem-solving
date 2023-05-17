#include <algorithm>
#include <string>
#include <vector>

using namespace std;
using ll = long long;
using point = pair<ll, ll>;

vector<point> find_points(vector<vector<int>>& line) {
    vector<point> points;
    for (int i = 0 ; i < line.size() - 1; i++) {
        for (int j = i + 1 ; j < line.size() ; j++) {
            vector<int>& l1 = line.at(i);
            vector<int>& l2 = line.at(j);
            ll ADBC = static_cast<ll>(l1.at(0)) * static_cast<ll>(l2.at(1)) - static_cast<ll>(l2.at(0)) * static_cast<ll>(l1.at(1));
            if (ADBC) {
                double x = (static_cast<double>(l1.at(1)) * static_cast<double>(l2.at(2)) - static_cast<double>(l1.at(2)) * static_cast<double>(l2.at(1))) / ADBC;
                double y = (static_cast<double>(l1.at(2)) * static_cast<double>(l2.at(0)) - static_cast<double>(l1.at(0)) * static_cast<double>(l2.at(2))) / ADBC;
                if (static_cast<ll>(x) == x && static_cast<ll>(y) == y) {
                    points.push_back({x, y});
                }
            }
        }
    }
    return points;
}

vector<string> find_star_field(vector<point>& points) {
    auto&& [x_min, x_max] = minmax_element(points.begin(), points.end(), [](auto&& i, auto&& j) -> bool {
        return i.first < j.first;
    });
    auto&& [y_min, y_max] = minmax_element(points.begin(), points.end(), [](auto&& i, auto&& j) -> bool {
       return i.second < j.second; 
    });
    vector<string> map(y_max->second - y_min->second + 1, string(x_max->first - x_min->first + 1, '.'));
    for (auto&& i : points) {
        map[abs(i.second - y_max->second)][abs(i.first - x_min->first)] = '*';
    }
    return map;
}

vector<string> solution(vector<vector<int>> line) {
    vector<point>&& points = find_points(line);
    return find_star_field(points);
}