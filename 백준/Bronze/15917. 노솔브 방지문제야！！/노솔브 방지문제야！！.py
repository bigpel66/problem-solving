import sys
input = sys.stdin.readline
Q = int(input())
list = []
for n in range(0,31):
    num = 2**n
    list.append(num)
    
for i in range(0,Q):
    a = int(input())
    if a in list:
        print("1")
    else:
        print("0")
 