package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Chapter9_2 {
	//무한의 값
	public static int INF = (int)1e9;
	//회사의 개수
	public static int N;
	public static int M;
	//그래프
	public static int[][] graph;
	//거쳐야 하는 K와 도착해야하는 X
	public static int K;
	public static int X;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//그래프 생성
		graph = new int[N+1][M+1];
		
		//그래프 INF로 초기화
		for (int i = 0; i <= N; i++) 
		{
			Arrays.fill(graph[i], INF);
		}
		
		//회사 i 에서 i 까지 거리는 0
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= M; j++) 
			{
				if(i == j)
				{
					graph[i][j] = 0;									
				}
			}
		}
		
		//회사간 거리 입력
		for (int i = 0; i < M; i++) 
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			//회사 간 이동 비용은 1 , 양방향
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		//K와 X입력
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st2.nextToken());
		K = Integer.parseInt(st2.nextToken());
		
		for (int k = 1; k <= N; k++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for (int a = 0; a <= N; a++) {
			for (int b = 0; b <= N; b++) {
				if(graph[a][b] == INF)
				{
					System.out.print(-1 + " ");					
				}
				else
					System.out.print(graph[a][b] + " ");
			}
			System.out.println();
		}
		
		System.out.println("K를 거쳐서 X로 가는 경로 값 : " + (graph[1][K] + graph[K][X]));
		
		
	}

}
