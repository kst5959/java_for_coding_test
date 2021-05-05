package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Chapter9_2 {
	//������ ��
	public static int INF = (int)1e9;
	//ȸ���� ����
	public static int N;
	public static int M;
	//�׷���
	public static int[][] graph;
	//���ľ� �ϴ� K�� �����ؾ��ϴ� X
	public static int K;
	public static int X;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//�׷��� ����
		graph = new int[N+1][M+1];
		
		//�׷��� INF�� �ʱ�ȭ
		for (int i = 0; i <= N; i++) 
		{
			Arrays.fill(graph[i], INF);
		}
		
		//ȸ�� i ���� i ���� �Ÿ��� 0
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
		
		//ȸ�簣 �Ÿ� �Է�
		for (int i = 0; i < M; i++) 
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			//ȸ�� �� �̵� ����� 1 , �����
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		//K�� X�Է�
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
		
		System.out.println("K�� ���ļ� X�� ���� ��� �� : " + (graph[1][K] + graph[K][X]));
		
		
	}

}
