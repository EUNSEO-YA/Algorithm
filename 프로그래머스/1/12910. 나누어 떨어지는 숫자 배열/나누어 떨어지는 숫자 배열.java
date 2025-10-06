import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> intList = new ArrayList<>();
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) intList.add(arr[i]);
        }
        
        if(intList.size() == 0) return new int[] {-1};
        
        return intList.stream().mapToInt(i->i).toArray();
    }
}