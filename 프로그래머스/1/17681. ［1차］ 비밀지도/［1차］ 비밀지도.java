class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] list = new String[n];
        
        for(int i = 0; i < n; i++) {
            list[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        
        for(int i = 0; i < n; i++) {
            String.format("%nd", list[i]);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(list[i].charAt(j) -'0' == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }    
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}