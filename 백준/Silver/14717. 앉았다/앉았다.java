import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Integer> all_card = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int card1 = Integer.parseInt(input[0]);
        int card2 = Integer.parseInt(input[1]);

        all_card.remove(Integer.valueOf(card1));
        all_card.remove(Integer.valueOf(card2));

        boolean isDdang = (card1==card2);
        double cases = 0;
        int my = 0; // 땡/끗 앞에 붙는 숫자
        if(isDdang) {
            my = card1;
            for(int i=0; i<all_card.size()-1; i++) {
                if(all_card.get(i+1)==all_card.get(i) && all_card.get(i)>card1) {
                    cases++;
                }
            }
            cases = 153-cases;
        } else {
            my = (card1+card2)%10;
            for(int i=0; i<all_card.size(); i++) {
                for(int j=0; j<all_card.size(); j++) {
                    if(i==j) continue;
                    if(i<=j) {
                        if((((all_card.get(i)+all_card.get(j))%10)<my) && all_card.get(i)!=all_card.get(j)) {
                            cases++;
                        }
                    }    
                }
            }
        }

        double probability = cases/153;
        System.out.printf("%.3f", probability);
    }   
}