import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        // 순간이동 -> (현재까지 온 거리) x 2
        // 점프 -> 하는만큼 건전지 소모됨
        
        while(n > 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n /= 2;
                ans++;
            }
        }

        return ans;
    }
}