import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = "";

        String[] str = s.split("");
        Arrays.sort(str);

        for(int i = str.length - 1; i >= 0; i--) {
            answer += str[i];
        }
        
        System.out.println(answer);
    }
}