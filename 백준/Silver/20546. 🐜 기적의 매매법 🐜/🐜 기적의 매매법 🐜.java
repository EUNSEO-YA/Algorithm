import java.util.Scanner;
    
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        sc.nextLine();

        int[] price = new int[14];
        for(int i = 0; i < 14; i++) {
            price[i] = sc.nextInt();
        }

        int june_money = money;
        int sung_money = money;

        int june_stock = 0;
        int sung_stock = 0;

        for(int i = 0; i < 14; i++) {
            if(price[i] <= june_money) {
                int buy = june_money / price[i];
                june_stock += buy;
                june_money -= buy * price[i];
            }
        }

        for(int i = 3; i < 14; i++) {
            if(price[i - 3] > price[i - 2] && price[i - 2] > price[i - 1]) {
                if(sung_money >= price[i]) {
                    int buy = sung_money / price[i];
                    sung_stock += buy;
                    sung_money -= buy * price[i];
                }
            } else if(price[i - 3] < price[i - 2] && price[i - 2] < price[i - 1]) {
                sung_money += sung_stock * price[i];
                sung_stock = 0;
            }
        }

        int june_total = june_money + june_stock * price[13];
        int sung_total = sung_money + sung_stock * price[13];

        if(june_total > sung_total) System.out.println("BNP");
        else if(june_total < sung_total) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    
    }
}