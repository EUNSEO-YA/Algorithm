class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 기사 - 1번부터 number까지 번호 지정되어 있음
        // 자신의 기사 번호의 약수 개수에 해당하는 공격력 가진 무기 구매
        // 공격력 제한수치보다 크면 정해진 공격력 무기 구매
        
        for(int i = 1; i <= number; i++) {
            int num = 0;
            for(int j = 1; j * j <= i; j++) {
                if(j * j == i) num++;
                else if(i % j == 0) num +=2;
            }
            if(num <= limit) answer += num;
            else answer += power;
        }
        
        return answer;
    }
}