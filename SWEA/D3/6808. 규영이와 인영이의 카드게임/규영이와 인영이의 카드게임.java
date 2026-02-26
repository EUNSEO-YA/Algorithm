import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] kyu;
	static int[] iny;
	
	static boolean[] card;
	
	static boolean[] visitedI;
	
	static int win;
	static int lose;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			kyu = new int[9];
			iny = new int[9];
			
			card = new boolean[19];
			visitedI = new boolean[9];
			
			win = 0;
			lose = 0;
			 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				card[kyu[i]] = true;
			}
			
			int idx = 0;
			for(int i = 1; i < 19; i++) {
				if(!card[i]) iny[idx++] = i;
			}
			
			dfs(0, 0, 0);
			
			sb.append(win).append(" ").append(lose).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx, int Kyuyoung, int Inyoung) {
		if(idx == 9) {
			if(Kyuyoung > Inyoung) win++;
			else if(Kyuyoung < Inyoung) lose++;
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!visitedI[i]) {
				visitedI[i] = true;
				
				int currentK = kyu[idx];
				int currentI = iny[i];
				int sum = kyu[idx] + iny[i];
				
				if(currentK > currentI) {
					dfs(idx + 1, Kyuyoung + sum, Inyoung);
				} else {
					dfs(idx + 1, Kyuyoung, Inyoung + sum);
				}
				
				visitedI[i] = false;
			}
		}
	}
}