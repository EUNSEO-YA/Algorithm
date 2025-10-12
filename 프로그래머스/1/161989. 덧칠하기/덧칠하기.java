class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] area = new int[n + 1];
        int paint = 1;
        
        for(int i = 0; i < section.length; i++) {
            area[section[i]] = 1;
        }
        
        while(paint <= n) {
            if(area[paint] == 0) paint++;
            else {
                answer++;
                if(paint + m > n) {
                    break;
                }
                else {
                    paint += m;
                }
            }
        }
        
        return answer;
    }
}