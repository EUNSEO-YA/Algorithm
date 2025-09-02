class Solution {
    public int solution(int[] cards) {
        int num1 = 0;
        int num2 = 0;
        
        boolean[] visited = new boolean[cards.length];
        
        int idx = 0;
        int re = 0;
        
        while(visited[idx] == true) {
            num1++;
            visited[idx] = true;
            idx = cards[idx];
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                re = i;
                break;
            }
        }
        
        while(visited[re] == true) {
            num2++;
            visited[re] = true;
            re = cards[re];
        }
        
        return num1 * num2;
    }
}