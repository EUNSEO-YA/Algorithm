import java.util.*;

class Main {
    static int[] check = new int[4];
    static int[] currentCount = new int[4];
    static int checkSecret = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String str = sc.next();

        char[] dna = str.toCharArray();
        int answer = 0;

        for(int i = 0; i < 4; i++) {
            check[i] = sc.nextInt();
        }

        for(int i = 0; i < P; i++) {
            addChar(dna[i]);
        }
        if(isValid()) answer++;

        for(int i = P; i < S; i++) {
            addChar(dna[i]);
            removeChar(dna[i - P]);
            if(isValid()) answer++;
        }

        System.out.println(answer);
    }

    static void addChar(char c) {
    switch (c) {
        case 'A':
            currentCount[0]++;
            break;
        case 'C':
            currentCount[1]++;
            break;
        case 'G':
            currentCount[2]++;
            break;
        case 'T':
            currentCount[3]++;
            break;
    }
}

static void removeChar(char c) {
    switch (c) {
        case 'A':
            currentCount[0]--;
            break;
        case 'C':
            currentCount[1]--;
            break;
        case 'G':
            currentCount[2]--;
            break;
        case 'T':
            currentCount[3]--;
            break;
    }
}

    static boolean isValid() {
        for(int i = 0; i < 4; i++) {
            if(currentCount[i] < check[i]) return false;
        }
        return true;
    }
}