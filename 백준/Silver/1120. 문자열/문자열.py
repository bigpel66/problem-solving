import sys

def input_action():
    first, second = sys.stdin.readline().split()
    return (first, second)

def solution(first, second):
    ans = 50
    for i in range(len(second) - len(first) + 1):
        count = 0
        for j in range(len(first)):
            if (first[j] != second[i + j]):
                count += 1
        ans = min(ans, count)
    return (ans)

def output_action(ans):
    sys.stdout.write(str(ans))

def main():
    first, second = input_action()
    ans = solution(first, second)
    output_action(ans)

main()