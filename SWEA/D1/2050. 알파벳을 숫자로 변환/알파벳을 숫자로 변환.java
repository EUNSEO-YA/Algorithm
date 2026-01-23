import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String T = sc.next();

        for(int i = 0; i < T.length(); i++) {
            System.out.print(T.charAt(i) - 'A' + 1 + " ");
        }
    }
}