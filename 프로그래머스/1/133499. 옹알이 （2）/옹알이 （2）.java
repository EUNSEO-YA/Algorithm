class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String s : babbling) {
            StringBuilder sb = new StringBuilder();
            boolean isValid = true;
            
            if(s.contains("ayaaya") || s.contains("yeye") || 
               s.contains("woowoo") || s.contains("mama")) {
                isValid = false;
            } else {
                for(char c : s.toCharArray()) {
                    sb.append(c);
                    String now = sb.toString();
                    
                    if(now.equals("aya") || now.equals("ye")
                      || now.equals("woo") || now.equals("ma")) {
                        sb.setLength(0);
                    }
                }   
            }
            
            if(isValid && sb.length() == 0) answer++;
        }
        
        return answer;
    }
}