import sys

def input_action():
    iter = int(sys.stdin.readline())
    students = []
    for i in range(iter):
        weight, height = map(int, sys.stdin.readline().split())
        students.append((weight, height))
    return (students)

def solution(students):
    ans = []
    for i in students:
        rank = 1
        for j in students:
            if (i[0] < j[0] and i[1] < j[1]):
                rank += 1
        ans.append(rank)
    return (ans)

def output_action(ans):
    for i in ans:
        sys.stdout.write(str(i) + ' ')

def main():
    output_action(solution(input_action()))

main()