def solution(my_string):
    answer = list(my_string)
    reverse = []
    for i in range(0, len(answer)):
        reverse.append(answer.pop())
        
    result = ''.join(reverse)
    return result