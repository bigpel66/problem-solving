ds, ys, dm, ym = map(int, open(0).read().split())
ps, pm = (ys - ds), (ym - dm)
while ps != pm:
    if ps < pm:
        ps += ys
    else:
        pm += ym
print(ps)
