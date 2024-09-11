def solution(edges):
    total = 0 
    max_id = 0
    answer = [0]*4
    for edge in edges:
        if max_id < max(edge):
            max_id = max(edge)
    
    in_list = [0]*(max_id)
    out_list = [0]*(max_id)
    
    for edge in edges:
        out_list[edge[0]-1] += 1
        in_list[edge[1]-1] += 1
    
    for i in range(len(in_list)):
        if out_list[i] == 0 and in_list[i]>=1:
            answer[2]+=1
        elif (in_list[i]>=2 and out_list[i]>=2):
            answer[3]+=1
        elif (in_list[i]==0 and out_list[i]>1):
            answer[0] = i+1
            total = out_list[i]
    
    answer[1] = total-answer[2]-answer[3]
    
    return answer
# 설명은 링크 참조 https://growingegg.tistory.com/137