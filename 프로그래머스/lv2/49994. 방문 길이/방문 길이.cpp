#include <string>
#include <unordered_set>
#include <utility>

using namespace std;

using point = pair<int, int>;
using edge = pair<point, point>;

template<>
struct hash<edge> {
    size_t operator()(edge e) const {
        return hash<int>{}(e.first.first) ^ hash<int>{}(e.first.second) ^ hash<int>{}(e.second.first) ^ hash<int>{}(e.second.second);
    }
};

int solution(string dirs) {
    unordered_set<edge> e;
    point cur = make_pair<int, int>(0, 0);
    for (int i = 0 ; i < dirs.length() ; i++) {
        point next;
        switch (dirs.at(i)) {
            case 'U':
                next = pair<int, int>(cur.first + 1, cur.second);
                break;
            case 'D':
                next = pair<int, int>(cur.first - 1, cur.second);
                break;
            case 'R':
                next = pair<int, int>(cur.first, cur.second + 1);
                break;
            case 'L':
                next = pair<int, int>(cur.first, cur.second - 1);
                break;
            default:
                return -1;
        }
        if (next.first < -5 || next.first > 5 || next.second < -5 || next.second > 5) {
            continue;
        }
        e.insert(edge(cur, next));
        e.insert(edge(next, cur));
        cur = next;
    }
    return e.size() / 2;
}