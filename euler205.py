a = [0]*37

def c(l,y):
	combinations(l,"",0,y)

def combinations(l,s,x,y):
	global a
	if x == y:
		r = 0
		for n in s:
			r += int(n)
		a[r] += 1
		return
	for e in l:
		combinations(l,s+e,x+1,y)

c("1234",9)
d4 = a[:]
a = [0]*37
c("123456",6)
d6 = a[:]

z = 0.0

for x in range(len(d6)):
	for y in range(x+1,len(d4)):
		z += d6[x]*d4[y]

print z/((4**9)*(6**6))

