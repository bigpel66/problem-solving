import sys

def input_action():
    case = int(sys.stdin.readline())
    oper = sys.stdin.readline().split()
    checker = [ False ] * 10
    answer = []
    return (case, oper, checker, answer)

def check(i, j, k):
    if (k == '<'):
        return i < j
    else:
        return i > j

def solution(case, oper, checker, answer, count, string):
    if (count == case + 1):
        answer.append(string)
        return
    for i in range(10):
        if (checker[i]):
            continue
        if (count == 0 or check(string[-1], str(i), oper[count - 1])):
            checker[i] = True
            solution(case, oper, checker, answer, count + 1, string + str(i))
            checker[i] = False

def output_action(case, answer):
    answer = list(map(int, answer))
    min_answer = str(min(answer))
    max_answer = str(max(answer))
    min_padd = "0" * (case + 1 - len(min_answer))
    max_padd = "0" * (case + 1 - len(max_answer))
    min_answer = min_padd + min_answer
    max_answer = max_padd + max_answer
    sys.stdout.write(max_answer + ' ' + min_answer)

def main():
    case, oper, checker, answer = input_action()
    solution(case, oper, checker, answer, 0, "")
    output_action(case, answer)

main()