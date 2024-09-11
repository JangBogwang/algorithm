from collections import deque 

def solution(targets):
    answer = 0 
    min_line = 0
    targets.sort()
    
    for target in targets:
        if target[0]+1 > min_line:
            answer +=1 
            min_line = target[1]
        elif target[1]<min_line:
            min_line = target[1]
        
    return answer

#https://growingegg.tistory.com/144


