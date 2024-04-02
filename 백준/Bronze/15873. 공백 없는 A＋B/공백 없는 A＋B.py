import sys


def input() -> int:
    return int(sys.stdin.readline())


def solve(value: int) -> None:
    if value % 10 == 0:
        sys.stdout.write(str(10 + value // 100))
    else:
        sys.stdout.write(str(value // 10 + value % 10))


solve(input())
