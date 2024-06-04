s = set()
for i in range(5):
    v = int(input())
    if v in s:
        s.remove(v)
    else:
        s.add(v)
print(s.pop())
