import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int idx = 0;
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(int i = 0; i < cards1.length; i++) {
            q1.add(cards1[i]);
        }
        
        for(int i = 0; i < cards2.length; i++) {
            q2.add(cards2[i]);
        }
        
        while(idx < goal.length) {
            if(!q1.isEmpty() && q1.peek().equals(goal[idx])) {
                q1.poll();
                idx++;
            } else if(!q2.isEmpty() && q2.peek().equals(goal[idx])) {
                q2.poll();
                idx++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}