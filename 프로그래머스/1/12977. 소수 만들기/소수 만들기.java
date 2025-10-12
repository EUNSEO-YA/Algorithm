class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean isPrime = true;

                    for(int s = 2; s <= Math.sqrt(sum); s++) {
                        if(sum % s == 0) isPrime = false;
                    }
                    
                    if(isPrime == true) answer++;
                }
            }
        }

        return answer;
    }
}