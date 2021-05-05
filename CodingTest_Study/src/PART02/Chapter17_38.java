package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chapter17_38 {

	public static int INF = (int)1e9;
	public static int N;
	public static int M;
	public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int a = 0; a <= N; a++) {
			for (int b = 0; b <= N; b++) {
				if(a == b) graph[a][b] = 0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			
			graph[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}

		int answer = 0;
		for (int a = 1; a <= N; a++) {
			int cnt = 0;
			for (int b = 1; b <= N; b++) {
				if(graph[a][b] != INF || graph[b][a] != INF)
				{
					cnt++;
				}
			}
			
			if(N == cnt) answer++;
		}
		
		System.out.println(answer);
	}

}
