import java.util.*;

class Solution {
    public int solution(int[] cards) {        
        boolean[] visited = new boolean[cards.length];
        List<Integer> sizes = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            if(!visited[i]) {
                int count = 0;
                int cur = i;
                
                while(!visited[cur]) {
                    visited[cur] = true;
                    count++;
                    cur = cards[cur] - 1;
                }
                if(count > 0) sizes.add(count);
            }
        }
        if(sizes.size() < 2) return 0;
        sizes.sort(Collections.reverseOrder());
        return sizes.get(0) * sizes.get(1);
    }
}