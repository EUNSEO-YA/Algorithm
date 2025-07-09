import java.util.*;

public class Main {
    public static void main(String[] args) {
    
		    List<Integer> triangle = new ArrayList<>();
		    
				Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i * (i + 1) / 2 <= 1000; i++) {
            triangle.add(i * (i + 1) / 2);
        }

        while (T-- > 0) {
            int K = sc.nextInt();
            boolean found = false;

            for (int i = 0; i < triangle.size(); i++) {
                for (int j = 0; j < triangle.size(); j++) {
                    for (int k = 0; k < triangle.size(); k++) {
                        int sum = triangle.get(i) + triangle.get(j) + triangle.get(k);
                        if (sum == K) {
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (found) break;
            }

            System.out.println(found ? 1 : 0);
        }
    }
}