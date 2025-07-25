class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int maxW = Math.max(wallet[0], wallet[1]);
        int minW = Math.min(wallet[0], wallet[1]);
        
        int w = bill[0];
        int h = bill[1];
        
        while(true) {
            int minB = Math.min(w, h);
            int maxB = Math.max(w, h);
            
            if(minB <= minW && maxB <= maxW) break;
            
            if(w >= h) w/= 2;
            else h /= 2;
            
            answer++;
        }
        
        return answer;
    }
}