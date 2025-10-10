class Solution {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            int num = food[i] / 2;
            
            for(int j = 0; j < num; j++) {
                sb1.append(i);
            }
        }
        
        StringBuilder sb2 = new StringBuilder(sb1);
        sb2.reverse();
        
        sb1.append(0);
        sb1.append(sb2);
        
        return sb1.toString();
    }
}