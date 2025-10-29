class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int num = 1;
        
        while(n > 0) {
            int plus = n % 3;
            sb.append(plus);
            n /= 3;
        }
        
        sb.reverse();
        
        for(int i = 0; i < sb.length(); i++) {
            int now = sb.charAt(i) - '0';
            answer += (now * num);
            num *= 3;
        }
        
        return answer;
    }
}