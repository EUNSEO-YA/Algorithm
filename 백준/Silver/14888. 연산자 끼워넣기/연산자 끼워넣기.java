import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        int[] opCount = new int[4];

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) opCount[i] = sc.nextInt();

        int opLen = N - 1;
        int[] ops = new int[opLen];
        boolean[] used = new boolean[opLen];
        int[] opPool = new int[opLen]; 

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            while (opCount[i]-- > 0) {
                opPool[idx++] = i; // 0:+, 1:-, 2:*, 3:/
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        java.util.Stack<Integer> depthStack = new java.util.Stack<>();
        java.util.Stack<Integer> resultStack = new java.util.Stack<>();
        java.util.Stack<boolean[]> usedStack = new java.util.Stack<>();
        java.util.Stack<int[]> opsStack = new java.util.Stack<>();

        depthStack.push(0);
        resultStack.push(nums[0]);
        usedStack.push(new boolean[opLen]);
        opsStack.push(new int[opLen]);

        while (!depthStack.isEmpty()) {
            int depth = depthStack.pop();
            int result = resultStack.pop();
            boolean[] usedNow = usedStack.pop();
            int[] opsNow = opsStack.pop();

            if (depth == opLen) {
                int temp = nums[0];

                for (int i = 0; i < opLen; i++) {
                    int op = opsNow[i];
                    int num = nums[i + 1];

                    if (op == 0) temp += num;
                    else if (op == 1) temp -= num;
                    else if (op == 2) temp *= num;
                    else {
                        if (temp < 0) temp = -(-temp / num);
                        else temp /= num;
                    }
                }

                if (temp > max) max = temp;
                if (temp < min) min = temp;

                continue;
            }

            for (int i = 0; i < opLen; i++) {
                if (!usedNow[i]) {
                    boolean[] nextUsed = usedNow.clone();
                    nextUsed[i] = true;

                    int[] nextOps = opsNow.clone();
                    nextOps[depth] = opPool[i];

                    depthStack.push(depth + 1);
                    resultStack.push(result);
                    usedStack.push(nextUsed);
                    opsStack.push(nextOps);
                }
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}