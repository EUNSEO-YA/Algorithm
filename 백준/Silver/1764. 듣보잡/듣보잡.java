import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>(N * 2);
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) list.add(name);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list.size()).append("\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}