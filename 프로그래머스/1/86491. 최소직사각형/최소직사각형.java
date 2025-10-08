class Solution {
    public int solution(int[][] sizes) {
        int minW = 0;
        int maxH = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.min(sizes[i][0], sizes[i][1]);
            int h = Math.max(sizes[i][0], sizes[i][1]);
            
            minW = Math.max(w, minW);
            maxH = Math.max(h, maxH);
        }
        
        return minW * maxH;
    }
}