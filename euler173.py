#Calculate the no. of possible square lamina with no. tiles "x" and hole width "h"
def calctiles(x,h):
	n = 0
	t = 0
	while t+4*(h+1) <= x:
		t += 4*(h+1)
		h += 2
		n += 1
	return n

#Calculate the no. of possible square lamina with no. tiles "x" using the calctiles fn.
def c(x):
	h = 1
	r = 0
	while (h+1)*4 <= x:
		r += calctiles(x,h)
		h += 1
	return r
	
print c(1000000)


