import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if(alpha[num] == -1) {
                alpha[num] = i;    
            } else {
                answer[i] = i - alpha[num];
                alpha[num] = i;
            }
        }
    
        return answer;
    }
}