def angle(t):
    a_s = (t%60)*6
    a_m = (t/10)%360
    a_h = (t/120)%360
    return a_h, a_m, a_s


def time_sum(h, m, s):
    return  h*3600+m*60+s

def solution(h1, m1, s1, h2, m2, s2):
    sum1 = time_sum(h1,m1,s1)
    sum2 = time_sum(h2,m2,s2)
    
    p_h, p_m, p_s = 0,0,0
    count = 0
    
    for i in range(sum1, sum2+1):
        a_h, a_m, a_s = angle(i)
        
        if a_h < a_s and p_h > p_s:
            count+=1
        elif a_h == a_s:
            count+=1
        elif p_h > p_s and a_s==0:
            count+=1
            
        if a_m < a_s and p_m > p_s:
            count+=1
        elif a_m == a_s:
            count+=1
        elif p_m > p_s and a_s==0:
            count+=1
        
        if a_m==0 and a_h==0 and a_s==0:
            count-=1
            
        p_h, p_m, p_s = a_h, a_m, a_s 
        
    answer = count
    return answer
# 설명은 링크 참조 https://growingegg.tistory.com/137