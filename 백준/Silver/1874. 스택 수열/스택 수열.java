import java.util.*;

class Main {
    public static void main(String[] args) {
        // 시간 2초 : 2 x 10^8

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int idx = 0;
        int num = 1;

        while(idx != n) {
            if(num <= list[idx]) {
                stack.push(num);
                num++;
                sb.append("+\n");
            } 
            
            while(!stack.isEmpty() && stack.peek() == list[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            }
            
            if (!stack.isEmpty() && stack.peek() > list[idx]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}