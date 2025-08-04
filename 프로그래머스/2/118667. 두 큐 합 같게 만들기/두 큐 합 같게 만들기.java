import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int count = 0;
        
        for(int i = 0; i < len * 3; i++) {
            if(sum1 == sum2) break;
            else {
                if(sum1 < sum2) {
                    int temp = q2.poll();
                    sum2 -= temp;
                    q1.add(temp);
                    sum1 += temp;
                    count++;
                } else {
                    int temp = q1.poll();
                    sum1 -= temp;
                    q2.add(temp);
                    sum2 += temp;
                    count++;
                }
            }
        }
        
        if(sum1 == sum2) return count;
        else return -1;
    }
}