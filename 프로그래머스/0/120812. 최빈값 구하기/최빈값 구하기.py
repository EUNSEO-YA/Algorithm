def solution(array):
    answer = 0
    t = [0] * 1001

    for v in array:
        t[v] += 1

    m = max(t)

    if t.count(m) > 1:
        return -1

    answer = t.index(m)

    return answer
