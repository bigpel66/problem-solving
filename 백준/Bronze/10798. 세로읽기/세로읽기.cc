#include <iostream>
#include <string>

int main() {
    std::string words[5]; // 입력된 단어를 저장할 배열

    // 단어 입력 받기
    for (int i = 0; i < 5; ++i) {
        std::cin >> words[i];
    }

    // 세로로 읽어서 출력하기
    for (int i = 0; i < 15; ++i) { // 최대 길이는 15
        for (int j = 0; j < 5; ++j) {
            if (i < words[j].length()) {
                std::cout << words[j][i];
            }
        }
    }

    return 0;
}