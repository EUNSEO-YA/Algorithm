class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        sb.reverse();
        
        int mul = 1;
        
        for(int i = 0; i < sb.length(); i++) {
            long num = sb.charAt(i) - '0';
            
            answer += (mul * num);
            mul *= 3;
        }
        
        return answer;
    }
}