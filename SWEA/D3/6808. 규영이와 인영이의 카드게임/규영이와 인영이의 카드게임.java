import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	static int[] kyu;
	static int[] in;
	
	static boolean[] isSelected;
	static boolean[] visited;
	
	static int allCase = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
	static int kyuWin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			isSelected = new boolean[19];
			kyu = new int[9];
			in = new int[9];
			
			visited = new boolean[9];
			
			kyuWin = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				kyu[i] = num;
				isSelected[num] = true;
			}
			
			int idx = 0;
			for(int i = 1; i < 19; i++) {
				if(!isSelected[i]) {
					in[idx++] = i;
				}
			}
			
			dfs(0, 0, 0);
			
			sb.append(kyuWin).append(" ").append(allCase - kyuWin).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int kyuNum, int inNum, int idx) {
		if(idx == 9) {
			if(kyuNum > inNum) kyuWin++;
			return;
		}
		
		// 순서가 있고, 중복되면 안된다 -> 조합
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int inYeong = in[i];
				
				int sum = kyu[idx] + inYeong;
				if(kyu[idx] > inYeong) {
					dfs(kyuNum + sum, inNum, idx + 1);
				} else {
					dfs(kyuNum, inNum + sum, idx + 1);
				}
				
				visited[i] = false;
			}
		}
	}

}