class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        
        for(int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if(alphabet[num] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - alphabet[num];
            }
            alphabet[num] = i;
        }
        
        return answer;
    }
}