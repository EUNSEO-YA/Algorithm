import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while(queue.size() > 1) {
            queue.poll();

            int num = queue.peek();
            queue.poll();
            queue.add(num);
        }

        System.out.println(queue.peek());
    }
}