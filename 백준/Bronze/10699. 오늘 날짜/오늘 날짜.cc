#include <chrono>
#include <ctime>
#include <iomanip>
#include <iostream>

using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    auto&& now = chrono::system_clock::now();
    auto&& time = chrono::system_clock::to_time_t(now);
    cout << put_time(localtime(&time), "%F");
    return 0;
}