import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] result;
	static int[] input;
	
	static boolean[] selected;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		input = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	static void dfs(int idx, int start) {
		if(idx == M) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				result[idx] = input[i];
				
				dfs(idx + 1,  i + 1);
				
				selected[i] = false;
			}
		}
	}

}