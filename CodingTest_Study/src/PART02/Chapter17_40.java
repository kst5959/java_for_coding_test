package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Chapter17_40 {

	public static int INF = (int)1e9;
	public static int N;
	public static int M;
	public static int[][] graph = new int[20001][20001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) 
				{
					graph[i][j] = 0;
					//graph[j][i] = 0;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int[] d = new int[N+1];
		
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					graph[a][b] = Math.min(graph[a][b] , graph[a][k] + graph[k][b]);
					if(a == 1)
					{
						//System.out.println(a + " to "+ b + " = " + graph[a][b]);
						if(graph[a][b] != INF)
						{
							d[k] = graph[a][b];							
						}
					}
				}
			}
		}
		
		Arrays.parallelSort(d);
		int first = 0;
		int second = d[d.length-1];
		int third = 0;
		for (int a = 1; a <= N; a++) {
			if (graph[1][a] == d[d.length-1]) {
				if(first == 0)
				{
					first = a;
				}
				third++;
			}
		}
		
		System.out.println(first + " " +second + " " + third);
	}
}
