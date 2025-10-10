class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // 콜라 빈 병 2개 = 콜라 1병 새거
        // 빈 병 2개 미만이면 = 콜라 못받음
        
        // 빈병 a - 콜라 b병 | 보유한 빈병 n
        
        while(n >= a) {
            int get = (n / a) * b;
            answer += get;
            n = (n % a) + get;
        }
        
        return answer;
    }
}