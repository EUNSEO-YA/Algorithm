def solution(a, b):
    answer = 0
    
    a = str(a)
    b = str(b)
    
    str1 = a + b
    str2 = b + a
    
    str1 = int(str1)
    str2 = int(str2)
    
    if str1 >= str2:
        answer = str1
    else:
        answer = str2
    
    return answer