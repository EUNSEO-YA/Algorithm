def solution(a, b):
	
	str1 = int(str(a) + str(b))
	str2 = int(str(b) + str(a))
	
	return max(str1, str2)