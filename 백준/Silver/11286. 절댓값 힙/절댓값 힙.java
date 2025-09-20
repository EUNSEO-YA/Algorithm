import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB) {
                return a - b;
            } else {
                return absA - absB;
            }
        });
        
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x != 0) {
                pq.add(x);
            } else {
                if(pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}