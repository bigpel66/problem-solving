#include <iostream>

using namespace std;

class sol {
private:

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void solve(void) {
        string answer = "SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n"
                        "N2 Bomber      Heavy Fighter  Limited    21        \n"
                        "J-Type 327     Light Combat   Unlimited  1         \n"
                        "NX Cruiser     Medium Fighter Limited    18        \n"
                        "N1 Starfighter Medium Fighter Unlimited  25        \n"
                        "Royal Cruiser  Light Combat   Limited    4         ";
        cout << answer;
    }

public:
    sol(void) {
        stream();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}