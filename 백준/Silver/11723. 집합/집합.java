import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                if(!list.contains(x)) list.add(x);
            } else if (s.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                list.remove(Integer.valueOf(x));

            } else if (s.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(list.contains(x) ? 1 : 0).append('\n');

            } else if (s.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (list.contains(x)) list.remove(Integer.valueOf(x));
                else list.add(x);

            } else if (s.equals("all")) {
                list.clear();
                for (int x = 1; x <= 20; x++) list.add(x);

            } else if (s.equals("empty")) {
                list.clear();
            }
        }

        System.out.print(sb.toString());
    }
}