import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        // 배열 돌면서 예산 합산해서 budget보다 작거나 같을 때까지 지원 가능
        // 최대한 많은 부서를 지원해줘야 함
        
        for(int i = 0; i < d.length; i++) {
            int sum = 0;
            int dept = 0;
            
            for(int j = 0; j < d.length; j++) {
                if(sum + d[j] <= budget) {
                    sum += d[j];
                    dept++;
                } else continue;    
            }
            answer = Math.max(answer, dept);
        }
        
        return answer;
    }
}