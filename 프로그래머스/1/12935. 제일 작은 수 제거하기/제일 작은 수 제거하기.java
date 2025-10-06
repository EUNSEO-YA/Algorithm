import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        
        if(arr.length == 1) return new int[] {-1};
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) list.add(arr[i]);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}