#include <iostream>

using namespace std;

class sol {
private:
    int min_to_subway;
    int bus_to_home;
    int subway_to_home;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> min_to_subway >> bus_to_home >> subway_to_home;
    }

    void solve(void) {
        if (min_to_subway > subway_to_home) {
            subway_to_home += min_to_subway;
        }
        if (bus_to_home < subway_to_home) {
            cout << "Bus";
        } else if (bus_to_home > subway_to_home) {
            cout << "Subway";
        } else {
            cout << "Anything";
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}