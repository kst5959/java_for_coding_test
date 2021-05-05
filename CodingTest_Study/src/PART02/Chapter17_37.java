package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chapter17_37 {

	public static int INF = (int) 1e9;
	public static int N;
	public static int M;
	public static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][M+1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int a = 1; a <= N; a++) {
			for (int b = 1; b <= N; b++) {
				if(a == b) graph[a][b] = 0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for (int a = 1; a <= N; a++) {
			for (int b = 1; b <= N; b++) {
				if(graph[a][b] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(graph[a][b]+ " ");
			}
			System.out.println();
		}
		
	}

}
