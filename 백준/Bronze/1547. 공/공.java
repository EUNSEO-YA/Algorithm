import java.util.Scanner;
    
public class Main {
    public static void main(String[] args) {
        int[] cup = new int[]{0, 1, 2, 3};
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        
        for(int i = 0; i < M; i++) {
		    sc.nextLine();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int temp = cup[X];
            cup[X] = cup[Y];
            cup[Y] = temp;
        }

        for(int i = 1; i <= 3; i++) {
            if(cup[i] == 1) {
                System.out.println(i);
            }
        }
    }
}