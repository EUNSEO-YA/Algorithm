import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        ArrayList<Integer> list = new ArrayList<>();
        
        // 시험 최대 10,000 문제
        int[] p1 = new int[] {1, 2, 3, 4, 5}; // 5
        int[] p2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] p3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i % 5]) score[0]++;
            if(answers[i] == p2[i % 8]) score[1]++;
            if(answers[i] == p3[i % 10]) score[2]++;
        }
        
        int maxNum = 0;
        
        for(int i = 0; i < 3; i++) {
            maxNum = Math.max(maxNum, score[i]);
        }
        
        for(int i = 0; i < 3; i++) {
            if(score[i] == maxNum) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}