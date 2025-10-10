import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // strings[i] 의 n번째, 즉 string[n - 1] 글자 기준으로 오름차순 정렬
        Arrays.sort(strings, (o1, o2) -> {
           if(o1.charAt(n) != o2.charAt(n)) {
               return o1.charAt(n) - o2.charAt(n);
           } else {
               return o1.compareTo(o2);
           }
        });
        
        return strings;
    }
}