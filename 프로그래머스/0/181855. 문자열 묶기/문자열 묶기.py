def solution(strArr):
    answer = [0] * 31
    
    for i, value in enumerate(strArr):
        answer[len(value)] += 1
    
    return sorted(answer)[-1]