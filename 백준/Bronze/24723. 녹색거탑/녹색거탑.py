import sys

def input() -> int:
    return int(sys.stdin.readline())

def solve(value: int):
    sys.stdout.write(str(1 << value))
    sys.stdout.flush()

solve(input())
