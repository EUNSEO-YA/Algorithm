import java.util.*;
import java.math.*;
import java.lang.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        return array[array.length/2];
    }
}